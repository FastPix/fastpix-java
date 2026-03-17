#!/bin/bash
# Script to set up GPG agent for signing

echo "Setting up GPG agent for signing..."

# Set GPG_TTY
export GPG_TTY=$(tty 2>/dev/null || echo "/dev/tty")

# Start GPG agent if not running
if ! pgrep -x "gpg-agent" > /dev/null; then
    echo "Starting GPG agent..."
    eval $(gpg-agent --daemon)
else
    echo "GPG agent already running"
fi

# Test GPG access
echo ""
echo "Testing GPG key access..."
gpg --list-secret-keys --keyid-format SHORT | grep "^sec" | head -2

echo ""
echo "To cache your password, run:"
echo "  echo 'YOUR_PASSWORD' | gpg --batch --yes --pinentry-mode loopback --passphrase-fd 0 --sign --default-key 4A1D43C6 /dev/null"
echo ""
echo "Then run: ./gradlew publishToMavenLocal"

