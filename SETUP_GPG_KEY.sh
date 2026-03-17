#!/bin/bash
# Script to generate a new GPG key for Maven publishing

echo "=========================================="
echo "GPG Key Generation for Maven Publishing"
echo "=========================================="
echo ""
echo "This script will help you generate a new GPG key."
echo "You'll need to:"
echo "  1. Choose key type (1 for RSA)"
echo "  2. Set key size (4096)"
echo "  3. Set expiration (0 for no expiration)"
echo "  4. Enter name: FastPix"
echo "  5. Enter email: devs@fastpix.io"
echo "  6. Enter a passphrase (remember this!)"
echo ""
read -p "Press Enter to start key generation..."

gpg --full-generate-key

echo ""
echo "=========================================="
echo "Getting your new key ID..."
echo "=========================================="
NEW_KEY_ID=$(gpg --list-secret-keys --keyid-format SHORT | grep "^sec" | tail -1 | awk '{print $2}' | cut -d'/' -f2)

if [ -z "$NEW_KEY_ID" ]; then
    echo "Error: Could not find new key ID. Please run manually:"
    echo "  gpg --list-secret-keys --keyid-format SHORT"
    exit 1
fi

echo "Your new key ID is: $NEW_KEY_ID"
echo ""
echo "=========================================="
echo "Uploading public key to keyserver..."
echo "=========================================="
gpg --keyserver keyserver.ubuntu.com --send-keys "$NEW_KEY_ID"

echo ""
echo "=========================================="
echo "Next Steps:"
echo "=========================================="
echo "1. Update gradle.properties with:"
echo "   signing.keyId=$NEW_KEY_ID"
echo "   signing.password=<YOUR_PASSPHRASE>"
echo ""
echo "2. Update Sonatype Central with key ID: $NEW_KEY_ID"
echo ""
echo "3. Test signing:"
echo "   ./gradlew publishToMavenLocal"
echo ""

