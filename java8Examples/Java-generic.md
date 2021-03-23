
### Generics in Methods 

```
final List<String> strings = ArraysList of Strings
buildCriteriaQuery(criteriaQuery, root,strings,CASE_ID);

final List<UUID> uuids = ArraysList of UUID
buildCriteriaQuery(criteriaQuery, root,uuids,IDS);


// List<T>
private <T>CriteriaQuery buildCriteriaQuery(

                                            final CriteriaQuery<CasePaymentOrderEntity> criteriaQuery,
                                            final Root<CasePaymentOrderEntity> root,
                                            final List<T> ids,
                                            final String fieldName
                                            ) {

        criteriaQuery.where(root.get(fieldName).in(ids));
        return criteriaQuery;
    }
```
