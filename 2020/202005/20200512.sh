#계산기가 필요한데, 

이제는 별짓을 다한다. 폿팅

dsu87dev#/home/jeus_hec> cat n.dat | awk '{sum+=$1; print $0} END {print "sum =",sum}'
1
2
3
4
5

sum = 15

dsu87dev#/home/jeus_hec> export sum=0
dsu87dev#/home/jeus_hec> for n in `cat n.dat`;^Jdo^Jsum=`expr $sum + $n`^Jdone
dsu87dev#/home/jeus_hec> echo $sum
15
