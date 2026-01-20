# Custories – Technical Architecture (MVP)

This document defines the technical architecture for the Custories MVP.
It is aligned with the locked MVP scope and is intended to support scalability,
resilience, and fast iteration.

---

## 1. High-Level Overview

Custories is composed of three main layers:

1. Web Application (Frontend + API)
2. Asynchronous AI Worker System
3. External Managed Services

All AI operations are asynchronous and isolated from user-facing requests.

---

## 2. Web Application

### Technology
- Next.js (React)
- Deployed on Vercel

### Responsibilities
- User authentication and session management
- Story configuration UI
- Chapter and character management
- Credit balance display
- Payment initiation
- Order tracking UI
- API endpoints for:
  - book creation
  - chapter configuration
  - AI job submission
  - status polling

### Backend API Model
- API routes are implemented inside the Next.js application
- No long-running operations in API routes
- All heavy work delegated to AI workers via job queue

---

## 3. Authentication

- Managed authentication provider
- Secure user sessions
- Role separation:
  - user
  - admin

Authentication logic is fully handled by the provider to minimize security risks.

---

## 4. Database

### Technology
- Supabase Postgres (managed)

### Responsibilities
- Users and profiles
- Books, characters, chapters, pages
- Credit balances and transactions
- AI job metadata and statuses
- Order and fulfillment tracking
- Admin audit logs

The database stores metadata only.
All binary assets are stored in object storage.

---

## 5. Object Storage

### Technology
- Supabase Storage (S3-compatible)

### Responsibilities
- Original user-uploaded images
- Generated character images
- Generated backgrounds
- Print-ready PDFs

Storage paths are structured by:
- user
- book
- chapter
- asset type

---

## 6. AI Worker System

### Responsibilities
- Character image consistency generation
- Style transformation (genre)
- Background generation
- Text generation
- Page composition
- PDF generation

### Execution Model
- One AI job per chapter
- Jobs are idempotent
- Failures are isolated per chapter
- Supports retries and manual re-runs

Workers run as a separate service and do not share runtime with the web app.

---

## 7. Job Lifecycle

Each AI job follows this lifecycle:
- pending
- running
- failed
- completed

Logs are stored persistently and exposed to admin users.

---

## 8. Payments

### Technology
- Stripe

### Model
- Credits-based system
- Credits purchased via one-time payments
- Credits consumed per AI generation

Refunds are handled manually by admin.

---

## 9. Print Fulfillment

- Integration with print-on-demand provider API
- Orders submitted only after successful generation
- Fulfillment status tracked in database

---

## 10. Environments

### Environments
- local
- dev
- staging
- production

Each environment has:
- separate database
- separate storage buckets
- isolated credentials

---

## 11. Scalability Principles

- Stateless web application
- Horizontally scalable AI workers
- Managed database and storage
- No single point of failure in user-facing flow

---

This architecture is considered validated for the Custories MVP.
Changes must be introduced in later phases.
