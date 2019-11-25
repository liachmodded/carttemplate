# carttemplate

## Overview

A *Minecraft* [Fabric](https://github.com/FabricMC) mod template by [@liachmodded](https://github.com/liachmodded).

Replace the readme with whatever you want!

This page should be included in the overview page of [the generated javadoc](https://liachmodded.github.io/carttemplate/overview-summary.html).

## Usage
- Change:
  - references in gradle.properties
  - the repo name in .travis.yml
  - the mixin json file's modid and package in the content, etc.
  - modid directory name under assets directory in main source set resources
  - `ID` field in mod main class (also rename mod main class)
  - change installed data generators
  - The license (default is MPL-2.0)
    - `codeLicense` in gradle.properties, need to be one that bintray accepts, e.g. `Unlicense`
    - change header
- For travis ci:
  - Add environmental variables:
    - `GITHUB_OAUTH_TOKEN`: a github access token that can push to this repo (for javadoc page and releasing) and to publish GitHub packages
    - `bintray_user`: the username of the bintray account that publishes stuff to bintray (for maven)
    - `bintray_key`: the access token for that bintray account

## Features
- Data generation via data generator (Forge has it, Fabric doesn't, so I wrote one)
- Auto license enforcement with licenser
- Auto publication of javadocs and releases to GitHub
  - Requires a GitHub OAUTH token
  - GitHub page may not show up on initial deployment, set GitHub page to build from a different source (e.g. master branch) and set it back to gh-pages branch to enlighten GitHub
- Auto publication of playable mod to GitHub Package Registry
  - Requires a GitHub OAUTH token
- Auto publication of mod to free, reliable maven (bintray; much better than jitpack, which stalls your gradle)
  - You need to link a GitHub account to bintray and obtain an api key
  - Maven repo is at `https://dl.bintray.com/${repoOwner}/${bintrayRepo}`
