void Change()
{
	//�޸�ר����Ϣ 
	Head();
	char Name[56];
	char operate;
	PMUS pFirst = pHead->pNext;	//ָ���һ���ڵ� �������Ϊ NULL pFirstΪ NULL
	printf("\t\t\t\t\t\t�޸�ר����Ϣ��\n\n\n");
	printf("\t\t\t\t\t\t������ר�����ƣ�");
	scanf("%s", Name);
	//����ר����Ϣ
	
	while (pFirst != NULL)	//��������ר�� 
	{
		if (strcmp(pFirst->mName, Name) == 0)
		{
			printf("\n\n\n\t\t\t\t\tҪ�޸ĵ�ר����Ϣ...\n\n");
			printf("\n\n\t\t\t\t\tר������\t����\t����\t��������\t������\n\n");
			printf("\t\t\t\t\t %s\t %s\t %s\t %d\t %d\t\t\n", pFirst->mName,
				pFirst->mSong, pFirst->mSinger
				, pFirst->mDate, pfirst->mFlow);
			printf("\n\n\n\t\t\t\t\t�Ƿ��޸ĸ�ר����Ϣ(y/Enter):");
			operate = getch();
			if (operate == 'y' || operate == 'Y' || operate == 13)	//13�ǻس���Enter��ASCIIֵ
			{
				//�޸�ȫ������
				printf("\n\n\t\t\t\t\t��������ר����Ϣ:\n\n\t\t\t\t\t\tר������:");
				scanf("%s", pFirst->mName);
				printf("\n\t\t\t\t\t\t����:");
				scanf("%s", pFirst->mSong);
				printf("\n\t\t\t\t\t\t����:");
				scanf("%s", pFirst->mSinger);
				printf("\n\t\t\t\t\t\t��������:");
				scanf("%d", &pFirst->mDate);
				printf("\n\t\t\t\t\t\t������:");
				scanf("%d", &pFirst->mFlow);
				
				printf("\n\n\n\t\t\t\t\t�޸ĳɹ�...\n\n");
				pFirst = NULL;
				return;
			}
			else {
				printf("\n\n\n\t\t\t\t\t�޸�ʧ��...\n\n");
				return;
			}
			return;
		}
		pFirst = pFirst->pNext;	//ָ����һ���ڵ�
	}
	pFirst = NULL;
	printf("\n\n\n\n\t\t\t\t\t   û���ҵ�Ҫ��ѯ��ר����Ϣ......\n\n");
	SaveDate(); 
}
