#로그 파일이 너무 크다. 파일 분할, ybd, 

cp was.20200507.log ~/log.0507

split -b 10m was.20200507.log

ls
#was.20200507.log  xai
#xaa               xaj
#xab               xak
...
#xah

grep 11:14:26 x*
#xav:2020-05-07 11:14:26 ...
#xav:2020-05-07 11:14:26 ...
#...

vi xav
/11:14:26
