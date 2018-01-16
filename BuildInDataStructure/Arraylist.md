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

// remove all the items in al.
al.clear();

// remove range
// start inclusive, end exclusive
al.removeRange(startIndex, endIndex);

// NOTE to remove range for a List type, use the code below
list.subList(start, end).clear();

al.add(obj)


// insert {obj} at index {id}
al.add(id, obj);

al.addAll({id,} Set s);

//HashMap(values) -> ArrayList:
ArrayList(map.values());

// clone
// this is shallow copy, which means the element in the al are still the same.
// NOTE List class have no clone function.
al.clone();
ArrayList<> new_al = new ArrayList<>(al);

// sort an ArrayList
Collections.sort(mArrayList, new Comparator<CustomData>() {
    @Override
    public int compare(CustomData lhs, CustomData rhs) {
        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
        return lhs.customInt > rhs.customInt ? -1 : (lhs.customInt < rhs.customInt) ? 1 : 0;
    }
});

// iterate
List<Integer> al = new ArrayList<>();
...
for(int a:al) {
    ...
}

// add null to array?
// we can add null to array of type that's not build in.
// But for some type like int && integer, in the iteration may cause some error:
for(int i: array) {} //error if contains null
for(Integer i: array) {} // pass


```
