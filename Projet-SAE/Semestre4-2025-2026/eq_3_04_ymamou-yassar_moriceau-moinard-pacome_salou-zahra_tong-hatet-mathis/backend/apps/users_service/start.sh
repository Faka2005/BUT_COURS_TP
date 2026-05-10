#!/usr/bin/env bash

mkdir "$(pwd)/mongo-memory/tmp"

export TMPDIR="$(pwd)/mongo-memory/tmp"

npm run dev --prefix apps/auth_service