#새로 만든 양식파일이 다른 ODI파일을 참조하고 있다.
#YBD

dir = 'D:/working/ODI연결확인_0519/'
files = os.listdir(dir) #[비교]폿팅
files = [fnm for fnm in files if fnm.endswith('.ozr')] #[비교]폿팅

for fn in files:
	with open(dir+fn, 'r', encoding='utf-8') as f:
		c = f.read()
		if not 'ODINAME=\"'+fn.strip('ozr')+'odi' in c :
			print('MISMATCH', '=>', fn)
		if not os.path.exists(dir+'odi/'+fn.replace('.ozr', '.odi')):
			print('NOTFOUND', '->', fn.replace('.ozr', '.odi'))
			
#MISMATCH => eformsample.ozr
#MISMATCH => test.ozr
#NOTFOUND -> test.odi
