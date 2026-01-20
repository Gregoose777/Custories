# Custories – MVP Scope Definition

This document defines the locked scope for the Custories MVP.
Anything not listed here is explicitly out of scope for the MVP.

---

## 1. Product Goal (MVP)

Enable a user to create a fully personalized illustrated storybook by:
- uploading character photos
- selecting a visual genre
- configuring chapters and themes
- generating the story with AI assistance
- ordering a printed version delivered to their home

---

## 2. Included Features (MVP)

### User & Access
- Web-based user authentication
- One user account per customer
- English language only

### Story Creation
- Create a new book project
- Upload character images (faces visible)
- Define up to **10 characters** per book
- Provide physical descriptions per character
- Select a visual genre (anime, manga, cartoon, realistic, etc.)

### Chapter Configuration
- User defines number of chapters
- Each chapter includes:
  - theme / description
  - visual context
- Maximum **5 pages per chapter**

### AI Generation (Asynchronous)
- Character consistency via image transformation
- Background generation per chapter
- Text generation per chapter
- Page assembly
- Print-ready PDF generation
- Chapter-level AI jobs (not book-level)

### Credits & Payments
- Credits-based pricing model
- Credits consumed based on:
  - AI generation usage
  - book size and complexity
- One-time payments to purchase credits
- No subscriptions

### Order & Fulfillment
- Print-on-demand provider API integration
- Order tracking status:
  - draft
  - paid
  - generating
  - ready
  - sent to print
  - shipped

### Admin (Internal)
- View AI generation logs
- Manual re-run of AI generation (chapter-level)
- Manual credit refunds
- Manual job intervention

---

## 3. Explicit Non-Features (MVP)

The following are NOT included in the MVP:

- Mobile applications
- Social features
- Sharing or collaboration
- Public galleries
- Template marketplace
- User-to-user interactions
- Automatic refunds
- Subscriptions
- Multi-language support
- Advanced story templates
- Real-time generation (everything is async)

---

## 4. Technical Constraints (MVP)

- AI generation must be resilient to failure
- All AI operations run asynchronously
- No blocking operations in web requests
- Assets stored in object storage, not database
- Relational database for all metadata

---

## 5. Scope Control Rule

Any feature not listed in this document:
- is considered out of scope
- must be proposed in a later phase
- must not be implemented during MVP development

This document is considered **frozen** once Phase 0 is completed.
