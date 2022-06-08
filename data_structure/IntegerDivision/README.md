**整数划分，是指把一个正整数n写成如下形式：**

​    **n=m1+m2+...+mi; （其中mi为正整数，并且1 <= mi <= n），则{m1,m2,...,mi}为n的一个划分。**

**如果{m1,m2,...,mi}中的最大值不超过m，即max(m1,m2,...,mi)<=m，则称它属于n的一个m划分。这里我们记n的m划分的个数为f(n,m);**

**例如但n=4时，他有5个划分，{4},{3,1},{2,2},{2,1,1},{1,1,1,1};**

**注意4=1+3 和 4=3+1被认为是同一个划分。**

该问题是求出n的所有划分个数，即f(n, n)。下面我们考虑求f(n,m)的方法;

递归法：

根据n和m的关系，考虑以下几种情况：

(1)当n=1时，不论m的值为多少（m>0)，只有一种划分即{1};

(2)当m=1时，不论n的值为多少，只有一种划分即n个1，{1,1,1,...,1};

(3)当n=m时，根据划分中是否包含n，可以分为两种情况：

(a)划分中包含n的情况，只有一个即{n}；**---------1**

(b)划分中不包含n的情况，这时划分中最大的数字也一定比n小，即n的所有(n-1)划分。**---------f(n,n-1)**

因此 f(n,n) =**1 + f(n,n-1)**;//这里就根据f的定义，由于划分中不包含n，最大的数字一定比n小，即比m小，所以f中第二个数为最接近n的数——n-1，而前一个数就是n，因为是对n进行划分，具体与下面f(n-m,m)
处道理一样

(4)当n<m时，由于划分中不可能出现负数，因此就相当于f(n,n);

(5)但n>m时，根据划分中是否包含最大值m，可以分为两种情况：

​    (a)划分中包含m的情况，即{m, {x1,x2,...xi}}, 其中{x1,x2,... xi} 的和为n-m，因此这情况下为f(n-m,m)

注意这里的前提是划分包含m，所以将m提出来一个，保证划分中一定会有m，剩下数字划分的和为n-m，而这n-m中可能不会出现m，也可能出现m，但由于我们已经提出了一个m，所以此处不用担心m是否再出现。根据f的定义，后f中的第二个数就是m了，而第一个数为什么是（n-m）,原因是提出一个m后，已经保证了划分中一定出现m，而n-m还没有进行划分，这里忽略提出的m，对剩下的整数n-m进行划分，划分的最大值仍然是m

​    (b)划分中不包含m的情况，则划分中所有值都比m小，即n的(m-1)划分，个数为f(n,m-1);

因此 f(n, m) = f(n-m, m)+f(n,m-1);

```java
q(6,4)：
	4+2,4+1+1;
	3+3,3+2+1,3+1+1;
	2+2+2,2+2+1+1,2+1+1+1+1;
	1+1+1+1+1+1;
```

可以将这些分为两部分，一部分是q(6,3),一部分是q(2,4)

```java
q(6,3):
	3+3,3+2+1,3+1+1;
	2+2+2,2+2+1+1,2+1+1+1+1;
	1+1+1+1+1+1;

q(2,4):
	4+2,4+1+1;
```

q(6,4) = q(6,3) + q(2,4)

**综上所述**：

```java
q(n, m)  = 1,                           n = 1 || m =1  
         = q(n, n)                      n < m  
         = 1 + q(n, n -1)               n = m         -----"1":"n = n"
         = q (n, m - 1) + q(n - m, m)   n > m >1
```
