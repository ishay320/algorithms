<div dir='rtl' lang='he'> 

# קורס אלגוריתמים
סיכום של קורס אלגוריתמים 1 ו-2 2021

# WIP - psudo:
* ## [תוכן עניינים](#****)  <!-- [ ] -->
  
* [Floyd Warshel - פלויד וורשל](#Floyd-Warshel) <!-- [x] -->

* [תת מערך עם סכום מקסימאלי](#תת-מערך-עם-סכום-מקסימאלי) <!-- [x] -->
  * [best-מציאת תת הטור הגדול ביותר](#Best) <!-- [x] -->
  * [cycle best-מציאת תת הטור הגדול ביותר רק במעגל](#Cycle-Best)    <!-- [x] -->
* [תת מטריצה עם סכום תאים מקסימאלי](#Super-Best-for-matrix) <!-- [x] -->

* [גרפים:](#גרפים)   <!-- [ ] -->
  * [dijkstra](#dijkstra)   <!-- [v] - need to go over the code -->
  * [BFS](#BFS) <!-- [v] -->
  * [DFS](#DFS) <!-- [ ] -->
  * [מציאת מספר רכיבי קשירות בגרף](#מציאת-מספר-רכיבי-קשירות-בגרף)    <!-- [ ] -->

* [עצים:](#Trees)  <!-- [ ] -->
  * [euiler](#euler)    <!-- [ ] -->
  * [שריפת עלים](#שריפת-עלים)  <!-- [ ] -->

* [עץ פורש מינימאלי](#עץ-פורש-מינימאלי) <!-- [ ] -->
  * [פריים](#פריים)   <!-- [ ] -->
  * [קרוסקל](#קרוסקל)  <!-- [ ] -->
  * [קרוסקל הפוך](#קרוסקל-הפוך) <!-- [ ] -->
  * [בורבוקה](#בורבוקה) <!-- [ ] -->

* [איזומורפיזם של עצים](#איזומורפיזם-של-עצים)   <!-- [ ] -->
* [בניית עץ מרשימת דרגות](#בניית-עץ-מרשימת-דרגות) <!-- [ ] -->
* [קוד האופמן](#קוד-האפמן)  <!-- [x] -->

</div>

<div dir='rtl' lang='he'> 
   
## Floyd Warshel
### תיאור
בגרף לא משוקלל, הקוד בודק אם קיים מסלול בין קודקוד למשנהו וגם מרחק הקצר ביותר כל זה מחושב במטריצת שכנויות.
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

# תת מערך עם סכום מקסימאלי

## Best
### תיאור
קוד חמדן שעובר על מערך ומחזיר את תת המערך הגדול ביותר שלו.
### דרך עבודה
רץ על המערך ואם הטור מקבל פחות מ0 מתחיל מהנקודה שאחרי.
### סיבוכיות
* `O(n)` <br>
### io
מקבל מערך<br>
מחזיר את הסכום, את ההתחלה ואת הסוף.
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

# גרפים

## dijkstra 
### תיאור

### דרך עבודה

### סיבוכיות
* `O(|V|log|V|)+O(|E|log|V|) = O((|V|+|E|)log|V|)` <br>
### io
`return distance, previous`
### פסודו
</div>

```python
dijkstra(G(E,V),startPoint):
    queue = PriorityQueue
    was = array[|V|]
    previous = array[|V|]
    distance = array[|V|]
    for i to |V|: //init
        was[i] = false
        distance[i] = infinity
        previous[i] = null
    queue.add(startPoint,0)

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

## BFS
### תיאור
מעבר על גרף באמצעות סריקה לרוחב
כלומר אפשר לדמיין שעובר במעגלים שכל פעם גדלים
### דרך עבודה
ממלא תור שזה אומר שהוא עובר תמיד על מה שנכנס ראשון שזה הקרוב ואחר כך עובר לרחוקים יותר.
### סיבוכיות
* `O(|V|+|E|)` 
### io
- מקבל גרף ונקודת התחלה
- מחזיר מערכי מרחק והורים
### פסודו
</div>

```python
BFS(G(V,E),start):
    # init:
    queue = new Queue # main queue
    color[len(V)]
    distance[len(V)]
    parent[len(V)]
    for i to len(V):
        color[i] = white
        distance[i] = infinity
        parent[i] = null

    # Algorithm:
    queue.add(start)
    while queue is not empty:
        vert = queue.dequeue()
        for neighbor in G(vert).neighbor():
            if(color[neighbor] == white): # if dident pass on him then add him to the queue
                color[neighbor] = gray
                distance[neighbor] = distance[vert] + 1
                parent[neighbor] = vert
                queue.add(neighbor)
        color[vert] = black # passed on the verticy so color it black
    return distance, arent
```

<div dir='rtl' lang='he'> 

## DFS
### תיאור
מעבר על גרף באמצעות סריקה לעומק
  
### דרך עבודה

### סיבוכיות
* `O(|V|+|E|)`
### io

### פסודו
</div>

```python
DFS(G) :
    for each v in V : v.color = WHITE
    for each v in V :
        if v.color = WHITE :
            DFS-VISIT(G, v)

DFS-VISIT(G, n) :
    n.color = GRAY
    for each v in adj[n] :
        if v.color = WHITE :
            DFS-VISIT(G, v)
    n.color = BLACK
```

<div dir='rtl' lang='he'> 

## מציאת מספר רכיבי קשירות בגרף
### תיאור

### דרך עבודה
משתמש ב `DFS`
### סיבוכיות
* `O(|V|+|E|)`
### io

### פסודו
</div>

```python
DFS-Number-Of-Connected-Components(G) :
    counter = 0
    for each v in V : v.color = WHITE
    for each v in V :
        if v.color = WHITE :
            counter++
            DFS-VISIT(G, v)
    return counter
```

<div dir='rtl' lang='he'> 

# Trees

## euler
### תיאור
מציאת מעגל אויילר בגרף
### דרך עבודה

### סיבוכיות
* `O(|V|+|E|)` <br>
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
    
   ## or
    
    Euler-Cycle(G) :
    select some vertex s from G 
    list C = ∅
    stack = {s}
    while stack ≠ ∅ :
        v = stack.peek()
        if v.degree = 0 :
            C.add(stack.pop())
        else :
            u = first of adj[v]
            stack.push(u)
            G.remove(u,v)
            G.remove(v,u)
    return C        
```

<div dir='rtl' lang='he'> 

## שריפת עלים
### תיאור
מציאת קוטר, רדיוס ומרכזים של עץ ע"י אלגוריתם שריפת עלים
  
### דרך עבודה

### סיבוכיות
* `O(|V|+|E|)`
### io

### פסודו
</div>

```python
Diameter-Fire(T) :
    n = |V|, radius = 0, leaves = ∅
    for each v in V :
        if v.deg = 1 :
            leaves.add(v)
    
    while n > 2 :
        future = ∅
        for each leaf in leaves :
            leaf.deg = 0
            n--
            for each v in adj[leaf] :
                if --v.deg = 1 :
                    future.add(v)
        radius++
        leaves = future

    diameter = radius*2 + |leaves|-1
    centers[] = leaves
    return {centers, radius, diameter}
```

<div dir='rtl' lang='he'> 
  
<!-- TODO: redo the psudo for pyton psudo and check all -->

# עץ פורס מינימאלי
## פריים
### תיאור

### דרך עבודה

### סיבוכיות
* `O(|V|+|E|log|V|)`
### io
מקבל גרף ומחזיר עץ
### פסודו
</div>

```python
MST-Prim(G) :
    T = ∅
    for each v in V :
        v.key = ∞
        v.prev = null
    V[0].key = 0
    Q = V
    while Q ≠ ∅ :
        u = Q.extractMin()
        if u.prev ≠ null :
            T.add((u, u.prev))
        for each v in adj[u] :
            if v in Q AND v.key > w(u,v) :
                v.key = w(u,v)
                v.prev = u
    return T
```

<div dir='rtl' lang='he'> 
  
<!-- TODO: redo the psudo for pyton psudo and check all -->

## קרוסקל
### תיאור
יצירת עץ פורס מינימאלי
### דרך עבודה

### סיבוכיות
* `O(|E|log|E|)`
### io
מקבל גרף ומחזיר עץ
### פסודו
</div>

```python
MST-Kruskal(G:graph,V:vertices) :
    T = Tree()
    for each v in V : 
        makeSet(v)
    sort E by weights
    for each (u,v) in E :
        if findSet(u) ≠ findSet(v) :
            T.add((u,v))
            union(u, v)
    return T
```

<div dir='rtl' lang='he'> 
  
<!-- TODO: redo the psudo for pyton psudo and check all -->

## קרוסקל הפוך
### תיאור

### דרך עבודה
הרעיון הוא להתחיל עם "עץ" שיש בו את כל הצלעות של G. נעבור על הצלעות מהגדולות לקטנות ונשאל על כל צלע האם אפשר לנתק אותה מהגרף והוא עדיין יישאר קשיר. אם כן נמחק את הצלע מהעץ, ככה באותו האופן עד שנגיע לעץ בגודל תקין.
  
### סיבוכיות
* `O(|E|(|E|+|V|))`
### io
מקבל גרף ומחזיר עץ
### פסודו
</div>

```python
MST-Reversed-Kruskal(G) :
    T = E
    Q = E
    while |T| > |V|-1 :
        e = Q.extractMax()
        G.removeEdge(e)
        if isConnected = false :
            G.addEdge(e)
    return T
```

<div dir='rtl' lang='he'> 
  
<!-- TODO: redo the psudo for pyton psudo and check all -->

## בורבוקה
### תיאור

### דרך עבודה

### סיבוכיות
* `O(|E|log|V|)`
### io
מקבל גרף ומחזיר עץ

### פסודו
</div>

```python
MST-Boruvka(G) :
    T = ∅
    for each v in V : makeSet(v)

    while |T| < |V|-1 :
        New cheapest[|V|] := array of edges
        for (u,v) in E :
            g1 = findSet(u)
            g2 = findSet(v)
            if g1 ≠ g2 :
                if w(cheapest[g1]) > w(u,v) :
                    w(cheapest[g1]) = w(u,v)
                if w(cheapest[g2]) > w(u,v) :
                    w(cheapest[g2]) = w(u,v)
        for i=0 to |v| :
            if cheapest[i] ≠ null :
                T.add(cheapest[i])
                union(cheapest[i].u, cheapest[i].v)
    return T
```

<div dir='rtl' lang='he'> 

## איזומורפיזם של עצים
### תיאור

### דרך עבודה
הרעיון הוא ליצור ייצוג בינארי כמחרוזת לכל עץ. אם המחרוזת של העץ הראשון זהה למחרוזת של העץ השני, אזי שני העצים איזומורפיים.
יצירת הייצוג הבינארי כמחרוזת לעץ מתחילה רקורסיבית מהשורש כלפי מטה, כאשר כל עלה מיוצג ע"י "01" וכל אבא משרשר את הייצוגים של הילדים שלו בסדר ממוין כאשר משמאל יש "0" ומימין יש "1".
אם לא נתון מה השורש של העץ אז נשתמש באלגוריתם שריפה למציאת מרכז העץ והוא יהיה השורש.
אם לעץ הראשון יש מרכז אחד ולשני יש שני מרכזים, אזי העצים לא איזומורפיים.
אם יש 2 מרכזים לעץ, נבדוק אם המחרוזת של העץ הראשון שווה למחרוזת של העץ השני בחילופי תפקידים בין המרכזים שנמצאו.
### סיבוכיות
* `O(VlogV)`
### io

### פסודו
</div>

```python
AHU-Tree-Isomorphism(T1, T2) :
    r1 = T1.root
    r2 = T2.root
    if r1 = null AND r2 = null :
        r1 = findCenter(T1)    // by Fire Algorithm
        r2 = findCenter(T2)
    New global List<String> childrenCodes[|V|]
    code1 = findCode(r1)
    code2 = findCode(r2)
    return (code1 == code2)

findCode(u)
    u.color = BLACK
    if u is a leaf :
        return "10"

    for each v in adj[u] :
        if v.color = WHITE :    // then v is child of u
            childrenCodes[u].add(findCode(v))
    Sort(childrenCodes[u])
    temp = ""
    for each s in childrenCodes[u] :
        temp += s
    return "1"+temp+"0"

```

<div dir='rtl' lang='he'> 

## בניית עץ מרשימת דרגות
### תיאור
צריך לבדוק קודם שאכן מתקיים Sum(degs) = 2*(|V|-1) לפני שמתחילים את האלגוריתם
הערה: האינדקס של האיבר הראשון במערך הוא 0, האינדקס של האיבר האחרון במערך הוא N-1.
### דרך עבודה

### סיבוכיות
*  `O(VlogV)` אם המערך לא ממוין. `O(V)` אם המערך ממוין כבר.
### io

### פסודו
</div>

```python
GenerateTreebyDegrees(deg[N]) :
    sort(deg)

    j = 0
    while deg[j] = 1 : j++
    
    New Tree[N,N] = {false}
    for i=0 to N-2 :
        Tree[i,j] = true
        Tree[j,i] = true
        if --deg[j] = 1 :
            j++
    Tree[N-2,N-1] = true
    Tree[N-1,N-2] = true
    return Tree
```


<div dir='rtl' lang='he'> 

## קוד האפמן
### תיאור
האפמן בא לפתור את זה ששימוש באותיות לפעמים תופס הרבה מקום,  
אז מה שעושה זה לקחת את האותיות שמופיעות הכי הרבה פעמים,  
ובטבלאת האותיות שלו הוא יקבע שהן יהיו כמה שיותר קטנים.  
וכך חוסך מקום בקבצי טקסט.
### דרך עבודה
שלב ראשון בניית העץ
שלב שני הוצאת הייצוגים הבינאריים של כל תו מהעץ
### סיבוכיות
* `O(n*log(n))` <br>
כאשר המערך ממוין על פי שכיחויות:
* `O(n)` <br>
### io
- מקבל מערך
- מחזיר עץ או מדפיס את הייצוג
### פסודו
</div>

```python
Huffman(C): # O(n*log(n)) making the tree
    Q = C
    while |Q| > 1 :
        New node z
        z.left = x = q.extractMin()
        z.right = y = q.extractMin()
        z.freq = x.freq + y.freq
        Q.insert(z)
    
Huffman-process(root = Huffman(C)): # O(n) printing
    if(root.left == null AND root.right == null) :
        print(root.char)
    else:
        print('0' + Huffman-process(root.left)
        print('1' + Huffman-process(root.right)
```
