# algorithm-study
알아두면 좋은 STL 
1. next_permutation
-혀 사용법: next_permutation(처음 주소, 마지막 주소)
ex) 배열 a[5]
next_permutation(a,a+5)

- 사용되는 곳: 순열, 조합

(1) 순열
(예: 5개 수를 오름차순으로 순열 (12345, 12354, ...)
int a[5]={1,2,3,4,5};
do{
 for(int i=0;i<5;i++){
  cout<<a[i];
 }
 cout<<"\n";
}while(next_permutation(a,a+5))

- 동작원리: next_permutation함수에서 현재 수열을 사전 순으로 다음 수열을 만들고 true 반환, 다음 수열이 존재하지 않으면 false 반환

(2) 조합
(예: 4개 수 중에서 순서없이 2개를 뽑는 경우의 수 (12, 13, 14, 23, 24, 34))
int a[4]={0,0,1,1};
do{
 for(int i=0;i<4;i++){
  if(a[i]==0){
   cout<<i+1;
  }
 }
 cout<<"\n";
}while(next_permutation(a,a+4))

- 동작원리 : 처음 배열이 오름차순으로 정렬되어 있다가, 값이 0인 것만 인덱스 번호에서 +1 해준 것만 출력된다. next_permutation에서 오름차순으로 다음 순열을 만들어주기에 차례대로 출력 가능
