<div dir='rtl' lang='he'> 

# algorithms
סיכום של קורס אלגוריתמים 1 ו-2 2021


# WIP - psudo:
* [Floyd Warshel - פלויד וורשל](#Floyd-Warshel)
* [best-מציאת תת הטור הגדול ביותר](#Best)
* [cycle best-מציאת תת הטור הגדול ביותר רק במעגל](#Cycle-Best)
* [super best for matrix-מציאת המרובע עם הסכום הגדול ביותר](#Super-Best-for-matrix)
* Graphs:
    * [dijkstra](#dijkstra)
    * [BFS](#BFS)
    * [DFS] ---  O(|V|+|E|)
    
* [Trees:](#Trees:) 
    * [euiler](#euler)
    * prime ---
    * krokshnitz --- 
</div>

<div dir='rtl' lang='he'> 
   
## Floyd Warshel
סיבוכיות: `O(n^3)` <br/>
 מחזיר מטריצה עם כל המרחקים </br>
האלגוריתם עובר ובודק האם בין שני נקודות קיים דרך קצרה יותר דרך נקודה נוספת K
</div>


```python
Floyd_Warshel(matrix mat):
    n = mat.length
    m = mat[0].length
    distance = new mat[n][m] 
    for i to n: #אתחול של המטריצה
        for j to m:
            if(mat[i][j] == 0 && i!=j):
                distance[i][j] = infinity
            else:
                distance[i][j] = mat[i][j]
    for k in mat: // ?
        for i to n:
            for j to m:
                if(distance[i][k]+distance[k][j]<distance[i][j]):
                    distance[i][j] = distance[i][k]+distance[k][j]
    return distance
```
<div dir='rtl' lang='he'> 

## Best
סיבוכיות: `O(n)` 
מחזיר את הסכום, את ההתחלה ואת הסוף      
 </div>
 
```python
best (Array array):
   start = 0
   best = 0
   sum = 0
   end = 0
   temp_start = 0
   for (i in array):
      sum += array[i]
   if (sum<0):
      sum = 0
      start = i+1
   if(best<sum):
      best = sum
      start = temp_start
      end = i
   return (best,start,end)
```
<div dir='rtl' lang='he'> 

## Cycle Best
סיבוכיות: `O(n)`
מחזיר סכום, התחלה וסוף אבל של מעגל(כלומר יכול להיות start>end)   
</div>

```python
cycle_best(Array array):
   array_r = -array # doing minus to all the array O(N)
   (r_best,r_start,r_end) = best(array_r)[best]
   (best,start,end) = best(array)
   if(best <array.sum()-(-r_best)):
      cycle_best =array.sum()-(-r_best) 
      return (cycle_best,r_end,r_start)
   return best(best,start,end)
```

## Super Best for matrix
`O(n^3)` return best,startCol,startRow,endCol,endRow

```python

```
## BFS
`O(|V|+|E|)`
```python
BFS(G(V,E),start)
queue = new Queue
color[|V|]
distance[|V|]
parent[|V|]
for i to |V|:
    color[i] = white
    distance[i] = infinity
    parent[i] = null
queue.add(start)
while queue is not empty:
    v = queue.dequeue()
    for neighbor in G(v).neighbor():
        if(color[neighbor] == white):
            color[neighbor] = gray
            distance[neighbor] = distance[v]+1
            parent[neighbor] = v
            queue.add(neighbor)
    color[v] = black
return distance,parent
```
## dijkstra 
`O((|V|+|E|)log|V|)` return distance, previous
```python
O(|V|log|V|)+O(|E|log|V|) = O((|V|+|E|)log|V|)
dijkstra(G(E,V),start)
queue = PriorityQueue
was = array[|V|]
previous = array[|V|]
distance = array[|V|]
for i to |V|: //init
    was[i] = false
    distance[i] = infinity
    previous[i] = null
queue.add(start,0)

while(!queue.empty())O(|V|)
    v = queue.popPriority()
    was[v] = true
    for neighbor in G(v): o(|E|)
        if(!was[neighbor] && distance[neighbor]>distance[v]+G.getEdge(v,neighbor).distance())
            distance[neighbor] = distance[v]+G.getEdge(v,neighbor).distance()
            previous[neighbor] = v
            if(queue.have(neighbor)) // O(log(n))
                queue.rePriority(neighbor,distance[neighbor])
            else
                queue.add(neighbor,distance[neighbor])
return distance, previous
```
# Trees:
## euler

```python
 euler_path (G=(v,e)){ 
        stack work, done;
        work.add(v1);
        while(!work.isempty()){
            v = work.peek();
            if (g(v).degree()==0){
                work.pop();
                done.add(v);
            }else {
                u = g(v)[0]; // take first neighbor
                work.add(u);
                g.delete(u,v);
            }
        }
        return done.toArray();
    }
```
