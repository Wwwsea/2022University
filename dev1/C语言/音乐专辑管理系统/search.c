void Search()
{
	Head();
	char Name[56];
	PMUS pFirst = pHead->pNext;	//ָ���һ���ڵ� �������Ϊ NULL pFirstΪ NULL
	printf("\t\t\t\t\t\t��ѯר����Ϣ��\n\n\n");
	printf("\t\t\t\t\t\t������ר�����ƣ�");
	scanf("%s", Name);
	//����ר����Ϣ

	while (pFirst != NULL)		//��������ר�� 
	{
		if (strcmp(pFirst->mName, Name) == 0)
		{
				printf("\n\n\n\t\t\t\t\tҪ��ѯ��ר����Ϣ...\n\n");
			printf("\n\n\t\t\t\t\tר������\t����\t����\t��������\t������\n\n");
			printf("\t\t\t\t\t %s\t %s\t %s\t %d\t %d\t\t\n", pFirst->mName,
				pFirst->mSong, pFirst->mSinger
				, pFirst->mDate, pfirst->mFlow);
			return;
		}
		pFirst = pFirst->pNext;	//ָ����һ���ڵ�
	}
	pFirs     t = NULL;
	printf("\n\n\n\n\t\t\t\t\t   û���ҵ�Ҫ��ѯ��ר����Ϣ......\n\n");
}
