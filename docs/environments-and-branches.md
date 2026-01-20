# Custories – Environments & Branching Strategy (MVP)

This document defines how code and configuration move from development
to production for the Custories platform.

It applies to all MVP development starting after Phase 0.

---

## 1. Environments

Custories uses four environments, each with a clear purpose.

### local
- Developer machine
- Used for active development and testing
- Can be unstable
- Uses local configuration and credentials

### dev
- Shared development environment
- Used for integrating features
- Not user-facing
- Can be unstable
- Mirrors production setup loosely

### staging
- Pre-production environment
- Used to validate a release candidate
- Should be as close to production as possible
- Used for final manual checks

### prod
- Production environment
- Used by real users
- Must be stable
- Changes only come from validated releases

---

## 2. Branches

The repository uses the following long-lived branches:

### main
- Represents production
- Always deployable
- Only updated from `staging`

### staging
- Represents pre-production
- Release candidate branch
- Used for final validation

### dev
- Integration branch
- All feature work is merged here first

### feature/*
- Short-lived branches
- One feature or fix per branch
- Created from `dev`
- Deleted after merge

---

## 3. Promotion Flow

Code moves through the system in the following order:
feature/* → dev → staging → main


Rules:
- No direct commits to `main`
- No direct commits to `staging`
- Features must be integrated into `dev` first
- Only stabilized code moves forward

---

## 4. Branch Protection (Initial Rules)

For the MVP phase:
- `main` is protected
- Direct pushes to `main` are disabled
- Merges into `main` must come from `staging`

Additional protections may be added in later phases.

---

## 5. Release Principle

A release is defined as:
- a merge from `staging` into `main`

Each release should:
- correspond to a coherent set of changes
- be traceable via Git history
- be deployable without additional changes

---

This strategy prioritizes clarity, safety, and low overhead during the MVP phase.

