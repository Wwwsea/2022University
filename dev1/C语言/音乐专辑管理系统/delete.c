void Delete()   //���ߣ�wanguy 
{
	//ɾ�����ר����Ϣ 
	Head();
	char Name[56];
	char operate;
	
	PMUS pFirst = pHead;	//ָ��ͷ���
	PMUS pTemp = pFirst->pNext;	//����PMUSָ�� pTemp ָ��Ҫɾ���Ľڵ�
	printf("\t\t\t\t\t\tɾ��ר����Ϣ��\n\n\n");
	printf("\t\t\t\t\t\t������ר�����ƣ�");
	scanf("%s", Name);
	//����ר����Ϣ
 
	
	while (pFirst->pNext != NULL)	//�����������ר�� 
	{
		if (strcmp(pFirst->pNext->mName, Name) == 0)
		{
			//��Ϣ��������Ҫɾ����ר����Ϣ
			printf("\n\n\n\t\t\t\t\tҪɾ����ר����Ϣ...\n\n");
			printf("\n\n\t\t\t\t\tר������\t����\t����\t��������\t������\n\n");
			printf("\t\t\t\t\t %s\t %s\t %s\t %d\t %d\t\t\n", pFirst->mName,
				pFirst->mSong, pFirst->mSinger
				, pFirst->mDate, pfirst->mFlow);
			printf("\n\n\n\t\t\t\t\t�Ƿ�ɾ����ר����Ϣ(y/Enter):");
			operate = getch();
			if (operate == 'y' || operate == 'Y' || operate == 13)	//13�ǻس���Enter��ASCIIֵ
			{
				//ɾ��ר����Ϣ

				pFirst->pNext = pTemp->pNext;	
				free(pTemp);
				iCount--;
				printf("\n\n\n\t\t\t\t\tɾ���ɹ�...\n\n");
				return;
			}
			else{
				printf("\n\n\n\t\t\t\t\tɾ��ʧ��...\n\n");
				return;
			}
		}
		pFirst = pFirst->pNext;	//ָ����һ���ڵ�
	}
	printf("\n\n\n\n\t\t\t\t\t   û���ҵ�Ҫɾ����ר����Ϣ......\n\n");
}
