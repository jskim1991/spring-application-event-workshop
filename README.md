### What is Event-Driven Architecture?
- ...
- ...
- ...

### What are some common patterns in EDA?
- ...
- ...
- ...

### How have you made your application event-driven in the past?
- ...
- ...
- ...

### Why use Events?
- Decoupling - Reduce tight coupling between components
- Flexibility - Add or change behavior without modifying existing logic
- Scalability - Handle high loads by processing events asynchronously
- Reliability - Events can be processed safely without being lost

### Example Real world use cases

| Use Case          | What Happens                                                                   |
|-------------------|--------------------------------------------------------------------------------|
| User registration | UserRegisteredEvent → listeners send welcome email, log activity, etc.         |
| Order placed      | OrderPlacedEvent → listeners handle inventory, notify warehouse, email receipt |
| Audit logging     | Listen to any domain event and persist an audit log                            |
| Search indexing   | After a new article is saved → trigger async search indexing                   |

### What is Spring Application Event?
- Provides a simple way for components in the **same application** to communicate using **publish-subscribe** model
- **In-memory event mechanism** based on the **observer pattern**, allowing **synchronous and asynchronous** communication between Spring beans

### Live Coding
- Internal Events
- Application Event Publisher & Event Listener
- Error Handling
- Asynchronous Event Listener
- Transactional Event Listener

### Case Study

| Use Case                     | What Happens                                                           |
|------------------------------|------------------------------------------------------------------------|
| In-App Notification          | Story is updated or export is completed → create notification for user |
| Live update signal           | Story is updated → update with the latest data for users               |
| Story Cycle time calculation | Story is updated → update story cycle time for analytics               |


### When Not to use Events?
- Cross-service communication
- When ordering is important
- When queuing, persistence, delivery guarantees, retries are needed





