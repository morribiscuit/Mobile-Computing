# Interfaces

## Java Code


AsyncHttpPost class receives the response from
server, but you actually want to use the result to modify views, which is easier from the activity. The
problem is that the onPostExecute method is in the AsyncHttpPost class rather than in the Activity. To
get around this, we ended up sending either the TextView or the Activity itself into the AsyncHttpPost
class as a parameter which we could then use to modify the interface. But the problem that would
come in then is how would we make this class reusable?

### That is what this code achieves.
