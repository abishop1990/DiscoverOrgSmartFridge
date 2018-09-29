# DiscoverOrgSmartFridge

Quick coding problem as a demonstration of Java understanding.

Written using Eclipse, can easily import and build in that environment.

Consists of a SmartFridge, provided SmartFridgeManager interface and a FridgeItem storage class.

Assumptions made:
- Items unique by ItemType
- Returning 0 for getFillFactor acceptable on empty/item not found
- Data attempted to insert will be sane
- Not intended to be thread-safe

Improvements Needed:
- Consider a database instead of local storage
- Write tests/test client
- Comment code for clarity