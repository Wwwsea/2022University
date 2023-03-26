void SaveData()          //作者：wanguy 
{
	FILE* fWrite = fopen("music.dat", "wb");
	if (fWrite == NULL)
	{
		system("cls");              //执行清屏，只能看见输出 
		printf("保存失败...\n");
		quit();
	}
	PMUS pFirst = pHead->pNext;	//指向第一个节点 如果链表为 NULL pCurrent为 NULL
	while (pFirst != NULL)		//遍历所有专辑信息	
	{
		fwrite(pFirst, sizeof(MUS), 1, fWrite);
		pFirst = pFirst->pNext;	//指向下一个节点
	}
	pFirst = NULL;
	fclose(fWrite);
}

