void Read()
{
	//读取专辑信息 
	FILE* fRead = fopen("music.dat", "rb");
	if (fRead == NULL)
	{
		SaveData();	//文件不存在就创建文件
		return;
	}
	rewind(fRead);	//将文件内部指针移回文件开头
	while (1)
	{
		pNew = (PMUS)malloc(sizeof(MUS));	//申请一块内存
		fread(pNew, sizeof(MUS), 1, fRead);	//1 表示读取一个MUS字节大小单元
		if (feof(fRead)) break;				//文件末尾退出
		//头插法插入数据
		pNew->pNext = pHead->pNext;			
		pHead->pNext = pNew;
		pNew = NULL;
		iCount++;
	}
	Sort();
	fclose(fRead);
}
