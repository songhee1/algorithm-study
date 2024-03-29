
# C++

알아두면 좋은 STL 
## 1. next_permutation

- 사용법: next_permutation(처음 주소, 마지막 주소)


ex) 배열 a[5]
next_permutation(a,a+5)

- 사용되는 곳: 순열, 조합

### (1) 순열

(예: 5개 수를 오름차순으로 순열 (12345, 12354, ...)

```c++
int a[5]={1,2,3,4,5};
do{
 for(int i=0;i<5;i++){
  cout<<a[i];
 }
 cout<<"\n";
}while(next_permutation(a,a+5))
```

- 동작원리 : next_permutation함수에서 현재 수열을 사전 순으로 다음 수열을 만들고 true 반환, 다음 수열이 존재하지 않으면 false 반환

 ### (2) 조합

(예: 4개 수 중에서 순서없이 2개를 뽑는 경우의 수 (12, 13, 14, 23, 24, 34))

```c++
int a[4]={0,0,1,1};
do{
 for(int i=0;i<4;i++){
  if(a[i]==0){
   cout<<i+1;
  }
 }
 cout<<"\n";
}while(next_permutation(a,a+4))
```

- 동작원리 : 처음 배열이 오름차순으로 정렬되어 있다가, 값이 0인 것만 인덱스 번호에서 +1 해준 것만 출력된다. next_permutation에서 오름차순으로 다음 순열을 만들어주기에 차례대로 출력 가능


<BR>
<bR>
<BR>
<BR>


# 최소공배수와 최대공약수 

<br>
<br>

### [관련된 문제]

- [백준 2609번 최대공약수 최소공배수 문제](https://www.acmicpc.net/problem/2609)
    - [문제 풀이 코드](https://github.com/songhee1/algorithm-study/blob/main/%ED%92%80%EA%B3%A0%EC%8B%B6%EC%9D%80%20%EB%AC%B8%EC%A0%9C/BOJ_2609.java)


- [백준 1188번 음식 평론가 문제](https://www.acmicpc.net/problem/1188)
    - [문제 풀이 코드](https://github.com/songhee1/algorithm-study/blob/main/%ED%92%80%EA%B3%A0%EC%8B%B6%EC%9D%80%20%EB%AC%B8%EC%A0%9C/BOJ_2609.java)

## (1) 최대공약수

- a와 b의 최대공약수를 (a,b) 라고 할 때, r = a mod b 라고 하자. 그러면 (a,b)의 최대공약수는 (b, r)의 최대공약수와 같다.

- 다시 말해 **GCD(a,b) = GCD(b, r)**과 같다.

- GCD(581, 322) = GCD(322, 259) = GCD = (259, 63) = GCD(63, 7) = GCD(7, 0) = 7;

- 결과적으로 나머지가 없다는 건 공통된 약수로 나누어 떨어진다는 의미이다. 따라서 7이 최대공약수가 됨을 알 수 있다.

- A = ad, B = bd(a,b는 서로소가 되며, 최대 공약수를 d라고 한다.)

- A = Bq+ r, r = A - Bq로 표현할 수 있다.
**r = A - Bq = ad - bdq = (a-bq)d**

- 따라서, B = db의 b와 a-bq는 서로소로 d가 최대공약수이다.

- **GCD(A,B) = GCD(B,r)** 임을 알 수 있다.

## (2) 최소공배수

- 앞서 A = ad, B = bd에서 a,b는 서로소, d는 최대공약수였다. 공통된 부분이 최대공약수 즉 d라는 의미이다.

- 따라서, 최소 공배수는 a*b*d가 된다.
최소 공배수를 구할 때는 **A * B % d**를 해도 만족하고, 
**a * b * d**를 해도 만족한다. 