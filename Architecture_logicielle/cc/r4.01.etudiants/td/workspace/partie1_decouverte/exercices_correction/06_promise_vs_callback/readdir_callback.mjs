"use strict"
import { readdir } from 'node:fs';

readdir(".", (err, files) => {
    if (err)
        console.log(err);
    else {
        files.forEach(file => console.log(file))
    }
})
