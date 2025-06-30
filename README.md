

### What is Spring Application Event?
- Provides a simple way for components in the **same application** to communicate using **publish-subscribe** model
- **In-memory event mechanism** based on the **observer pattern**, allowing **synchronous and asynchronous** communication between Spring beans

### Why use Events?
- Decoupling - Reduce tight coupling between components
- Separation of Concerns - Keep core logic clean
- Flexibility - Add or change behavior without modifying existing logic
- Extendability - Easily hook into business flows with new listeners

### Example Real world use cases

| Use Case          | What Happens                                                                   |
|-------------------|--------------------------------------------------------------------------------|
| User registration | UserRegisteredEvent → listeners send welcome email, log activity, etc.         |
| Order placed      | OrderPlacedEvent → listeners handle inventory, notify warehouse, email receipt |
| Audit logging     | Listen to any domain event and persist an audit log                            |
| Search indexing   | After a new article is saved → trigger async search indexing                   |

### Live Coding
- Internal Events
- Application Event Publisher & Event Listener
- Error Handling
- Asynchronous Event Listener
- Transactional Event Listener

### Case Study

| Use Case                     | What Happens                                                           |
|------------------------------|------------------------------------------------------------------------|
| In-app Notification          | Story is updated or export is completed → create notification for user |
| Live update signal           | Story is updated → update with the latest data for users               |
| Story Cycle time calculation | Story is updated → update story cycle time for analytics               |


### When Not to use Events?
- Cross-service communication
- When ordering is important
- When queuing, persistence, delivery guarantees, retries are needed





