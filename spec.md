# Payments Platform - Webhook Integration Spec

*Internal - Payments Platform Team*

## Overview

The Payments Platform team will POST payment status notifications to your
service as payment events are processed. Your service is responsible for
updating order state in response.

## Endpoint

```
POST /webhooks/payment
Content-Type: application/json
```

## Request Payload

```json
{
  "type": "payment.completed",
  "orderId": "ord_8f3kp2",
  "amount": 4999,
  "currency": "USD",
  "customerId": "cust_1a2b3c",
  "timestamp": "2024-01-15T09:23:38Z"
}
```

Event types: `payment.completed`, `payment.failed`

## Expected Response

Return `200 OK` to acknowledge receipt. Any non-2xx response will trigger a
retry.

## Retry Behavior

Failed deliveries are retried up to 5 times with exponential backoff. The
payments team cannot guarantee exactly-once delivery.
