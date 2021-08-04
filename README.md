<div dir='rtl' lang='he'> 

# קורס אלגוריתמים
סיכום של קורס אלגוריתמים 1 ו-2 2021


# WIP - psudo:
* ## [תוכן עניינים](#****)
  
* [Floyd Warshel - פלויד וורשל](#Floyd-Warshel)
  
* [תת מערך עם סכום מקסימאלי](#)
  * [best-מציאת תת הטור הגדול ביותר](#Best)
  * [cycle best-מציאת תת הטור הגדול ביותר רק במעגל](#Cycle-Best)
* [תת מטריצה עם סכום תאים מקסימאלי](#Super-Best-for-matrix)
  
* [גרפים:](#)
  * [dijkstra](#dijkstra)
  * [BFS](#BFS)
  * [DFS](#DFS)
  * [מציאת מספר רכיבי קשירות בגרף]()
* [עץ פורש מינימאלי](#)
  * [פריים]()
  * [קרוסקל]()
  * [קרוסקל הפוך]()
  * [בורבוקה]()
  
* [עצים:](#Trees:)
  * [euiler](#euler)
  * [שריפת עלים]()
* [קוד האופמן](#קוד_האפמן)
* [איזומורפיזם של עצים]()
* [בניית עץ מרשימת דרגות]()

</div>

<div dir='rtl' lang='he'> 
   
## Floyd Warshel
### תיאור
קוד שבודק האם קיים מסלול בין קודקוד כלשהו לקודקוד אחר וגם מרחק הקצר ביותר.
### דרך עבודה
האלגוריתם עובר ובודק האם בין שני נקודות קיים דרך קצרה יותר דרך נקודה נוספת K.
### סיבוכיות
* `O(n^3)` <br>
בודק מעבר דרך קודקוד `O(n)` ובכל מעבר עובר על מטריצה `O(n^2)`<br>
`O(n)*O(n^2) = O(n^3)`<br>
### io
מקבל מטריצת שכנויות<br>
מחזיר מטריצת שכנויות עם המרחקים
### פסודו 
</div>

```python
Floyd_Warshel(matrix mat):
    n = mat.length
    distance = new mat[n][n] 
    for i to n: # אתחול של המטריצה
        for j to n:
            if(mat[i][j] == 0 && i!=j):
                distance[i][j] = infinity
            else:
                distance[i][j] = mat[i][j]
                
    for k=0 to n: 
        for i=0 to n:
            for j=0 to n:
                if( distance[i][k]+distance[k][j] < distance[i][j] ):
                    distance[i][j] = distance[i][k]+distance[k][j]
    return distance
```
<div dir='rtl' lang='he'> 

## Best
### תיאור
קוד חמדן שעובר על מערך ומחזיר את תת המערך הגדול ביותר שלו.
### דרך עבודה
רץ על המערך ואם הטור מקבל פחות מ0 מתחיל מהנקודה שאחרי.
### סיבוכיות
* `O(n)` <br>
### io
מקבל מערך<br>
מחזיר את הסכום, את ההתחלה ואת הסוף
### פסודו
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
        temp_start = i+1
      if(best<sum):
        best = sum
        start = temp_start
        end = i
   return (best,start,end)
```
<div dir='rtl' lang='he'> 

## Cycle Best
### תיאור
קוד חמדן שעובר על מערך ומחזיר את תת המערך הגדול ביותר שלו רק במעגל.
### דרך עבודה
בעצם הוא בודק אם המשלים של המערך(תת מערך עם הסכום המינימאלי) פחות סכום המערך גדול יותר.
### סיבוכיות
* `O(n)` <br>
### io
מקבל מערך<br>
מחזיר סכום, התחלה וסוף אבל של מעגל(כלומר יכול להיות `start>end`)
### פסודו
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
<div dir='rtl' lang='he'> 

## Super Best for matrix
### תיאור
קוד חמדן שעובר על מטריצה ומחזיר את תת המטריצה עם הסכום הגדול ביותר.
### דרך עבודה
מחבר שורות למערך עזר ואז מפעיל את `best`
### סיבוכיות
* `O(n^3)` <br>
### io
מקבל מטריצה<br>
`best,startCol,startRow,endCol,endRow`
### פסודו
</div>


```python
Super-Best(matrix mat[rows,cols]) :
    maxSum, start_x, start_y ,end_x, end_y = 0

    for i=0 to rows :
        New help[cols]
        for j=i to rows :
            for k=0 to cols :
                help[k] += mat[j,k]
            tempSum, tempStart, tempEnd = best(help)
            if maxSum < tempSum :
                maxSum = tempSum
                start_x = tempStart
                end_x = tempEnd
                start_y = i
                end_y = j
    return (maxSum, start_x, start_y, end_x, end_y)
```
<div dir='rtl' lang='he'> 

## BFS
### תיאור

### דרך עבודה

### סיבוכיות
* `O(|V|+|E|)` <br>
### io

### פסודו
</div>

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
<div dir='rtl' lang='he'> 

## DFS
### תיאור

### דרך עבודה

### סיבוכיות
* `O(|V|+|E|)` <br>
### io

### פסודו
</div>

```python
```
<div dir='rtl' lang='he'> 

## dijkstra 
### תיאור

### דרך עבודה

### סיבוכיות
* `O((|V|+|E|)log|V|)` <br>
### io
`return distance, previous`
### פסודו
</div>

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
<div dir='rtl' lang='he'> 

# Trees:

## euler
### תיאור

### דרך עבודה

### סיבוכיות
* `O()` <br>
### io

### פסודו
</div>

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
<div dir='rtl' lang='he'> 

## קוד האפמן
### תיאור

### דרך עבודה
שלב ראשון בניית העץ
שלב שני הוצאת הייצוגים הבינאריים של כל תו מהעץ
### סיבוכיות
* `O(n*log(n))` <br>
כאשר המערך ממוין על פי שכיחויות:
* `O(n)` <br>
### io

### פסודו
</div>

```python
Huffman(C): # O(n*log(n))
    Q = C
    while |Q| > 1 :
        New node z
        z.left = x = q.extractMin()
        z.right = y = q.extractMin()
        z.freq = x.freq + y.freq
        Q.insert(z)
    
Huffman-process(root = Huffman(C)): # O(n)
    if(root.left == null AND root.right == null) :
        print(root.char)
    else:
        print('0' + Huffman-process(root.left)
        print('1' + Huffman-process(root.right)
```