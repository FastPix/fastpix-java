#!/bin/bash
# Script to publish to local Maven repository with proper GPG configuration

# Set GPG_TTY to fix "Inappropriate ioctl for device" error
export GPG_TTY=$(tty 2>/dev/null || echo "/dev/tty")

# Run the publish command
./gradlew publishToMavenLocal "$@"

