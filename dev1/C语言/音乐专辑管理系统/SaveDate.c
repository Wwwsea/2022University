void SaveData()          //���ߣ�wanguy 
{
	FILE* fWrite = fopen("music.dat", "wb");
	if (fWrite == NULL)
	{
		system("cls");              //ִ��������ֻ�ܿ������ 
		printf("����ʧ��...\n");
		quit();
	}
	PMUS pFirst = pHead->pNext;	//ָ���һ���ڵ� �������Ϊ NULL pCurrentΪ NULL
	while (pFirst != NULL)		//��������ר����Ϣ	
	{
		fwrite(pFirst, sizeof(MUS), 1, fWrite);
		pFirst = pFirst->pNext;	//ָ����һ���ڵ�
	}
	pFirst = NULL;
	fclose(fWrite);
}

