void Read()
{
	//��ȡר����Ϣ 
	FILE* fRead = fopen("music.dat", "rb");
	if (fRead == NULL)
	{
		SaveData();	//�ļ������ھʹ����ļ�
		return;
	}
	rewind(fRead);	//���ļ��ڲ�ָ���ƻ��ļ���ͷ
	while (1)
	{
		pNew = (PMUS)malloc(sizeof(MUS));	//����һ���ڴ�
		fread(pNew, sizeof(MUS), 1, fRead);	//1 ��ʾ��ȡһ��MUS�ֽڴ�С��Ԫ
		if (feof(fRead)) break;				//�ļ�ĩβ�˳�
		//ͷ�巨��������
		pNew->pNext = pHead->pNext;			
		pHead->pNext = pNew;
		pNew = NULL;
		iCount++;
	}
	Sort();
	fclose(fRead);
}
