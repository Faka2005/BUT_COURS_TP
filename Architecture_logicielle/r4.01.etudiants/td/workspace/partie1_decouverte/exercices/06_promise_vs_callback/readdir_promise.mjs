"use strict"
import { readdir } from 'node:fs/promises';
try {const files = await readdir(".")
files.forEach(file => console.log(file))
} catch (err) {
console.error(err);
}