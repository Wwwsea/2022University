void Show()
{
	//չʾ����ר����Ϣ 
	Head();
	PMUS pFirst = pHead->pNext;	//ָ���һ���ڵ� �������Ϊ NULL pCurrentΪ NULL
	int i = 1;
	printf("\t\t\t**********************���������� %d ��ר��*********************\n\n\n", iCount);
	printf("\t\t\t���\tר������\t��������\t����\t��������\t������\t�ܷ�\n\n");
	while (pFirst != NULL)	//�����������ר�� 
	{
		printf("\t\t\t %d\t %s\t %s\t %s\t %d\t\t%d\n",i,pFirst->mName,pFirst->mSong
			, pFirst->mSinger, pFirst->mDate, pFirst->mFlow);
		pFirst = pFirst->pNext;	//ָ����һ���ڵ�
		i++;	//�±�Ӽ�
	}
	pFirst = NULL;
	printf("\n\n\n");
}

