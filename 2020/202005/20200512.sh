#계산기가 필요한데, 

이제는 별짓을 다한다. 폿팅. 이거 파일 다시 만들기.또는 이럭삭제
 cat n.dat | awk '{sum+=$1; print $0} END {print "sum =",sum}'
1
2
3
4
5

sum = 15

export sum=0
dsu87dev#/home/jeus_hec> for n in `cat n.dat`;^Jdo^Jsum=`expr $sum + $n`^Jdone
dsu87dev#/home/jeus_hec> echo $sum
15
