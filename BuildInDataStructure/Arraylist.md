### ArrayList
```
arraylist.size()

arraylist.toArray()

arraylist.get(id)

// if use set here, must promise the id will be in the range of the arraylist,
// otherwise will throw IndexOutOfBoundsException.
arraylist.set(id, obj)

al.remove(id)

al.remove(obj)

al.clear()

al.add(obj)

al.add(id, obj) = set

al.addAll({id,} Set s)

HashMap(values) -> ArrayList:
    ArrayList(map.values())

al.clone();
ArrayList<> new_al = new ArrayList<>(al)
    this is shallow copy, which means the element in the al are still the same.

    NOTE: List class have no clone function.

```
