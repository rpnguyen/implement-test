# Interviewer Guide - Virtual 1: Implement (AI-Assisted)

> **Do not share this file with candidates.**

## Setup (1 min)

"Here's a spec for a webhook handler the payments team needs built. Use Claude
Code to implement it - talk me through your approach as you go: what questions
you'd want answered before starting, and what you'd want to validate before
shipping."

> **Note on the README:** It is intentionally minimal and realistic - no interview
> framing. Observe whether the candidate treats documentation as part of the
> deliverable and updates the README to reflect their implementation.

---

## What to Look For

**Process over completeness** - a candidate who asks clarifying questions
upfront, reasons about edge cases before writing code, and validates their output
is more valuable than one who ships quickly but silently.

**Questions before coding** - strong candidates will probe the spec before
starting. Watch for:
- "What should happen on duplicate delivery?" (idempotency)
- "How do we verify the request is from the payments processor?" (auth/signature)
- "What's the retry behaviour if we return a non-2xx?" (reliability contract)
- "Are there rate or volume expectations?" (scalability)

**AI as accelerator, not author** - do they direct Claude with intent, or
accept the first output? Watch whether they review generated code critically
and catch issues before moving on.

**Security instincts** - signature verification and input validation are in the
spec implicitly (the payments team controls the secret). Do they raise it
unprompted?

**Testing approach** - the test directory is absent intentionally. Do they notice
and add tests? Do they write unit tests, HTTP-level tests, or skip testing
entirely?

**Documentation** - do they update the README to reflect what they actually built?

---

## Probing Questions

| Area | Example questions |
|------|-------------------|
| Design | "Walk me through how you'd handle a duplicate event." / "What happens if the order isn't found?" |
| Security | "How does your handler know this request came from the payments processor?" |
| Reliability | "The payments team retries on any non-2xx - what does that mean for your handler?" |
| Testing | "How would you verify this works end-to-end before shipping?" |
| Observability | "A customer says their payment went through but nothing happened - how do you investigate?" |

---

## Stretch Goal

"The spec only covers `payment.completed` and `payment.failed`. The payments
team wants to add `payment.disputed` - walk me through how you'd extend this
without breaking existing behaviour."

Strong candidates will reason about the open/closed principle, idempotency
applying equally to the new event, and what new downstream behaviour (e.g.
refund initiation) implies for error handling and observability.

---

## Strong Signal

Asks clarifying questions before coding, raises security and idempotency
unprompted, reviews Claude's output critically, writes tests, and updates
documentation.

## Weak Signal

Starts coding immediately, accepts Claude's first output without review, skips
tests, and leaves the README unchanged.
