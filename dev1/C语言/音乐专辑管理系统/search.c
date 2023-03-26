void Search()
{
	Head();
	char Name[56];
	PMUS pFirst = pHead->pNext;	//指向第一个节点 如果链表为 NULL pFirst为 NULL
	printf("\t\t\t\t\t\t查询专辑信息：\n\n\n");
	printf("\t\t\t\t\t\t请输入专辑名称：");
	scanf("%s", Name);
	//遍历专辑信息

	while (pFirst != NULL)		//遍历所有专辑 
	{
		if (strcmp(pFirst->mName, Name) == 0)
		{
				printf("\n\n\n\t\t\t\t\t要查询的专辑信息...\n\n");
			printf("\n\n\t\t\t\t\t专辑名称\t歌曲\t歌手\t发售日期\t销售量\n\n");
			printf("\t\t\t\t\t %s\t %s\t %s\t %d\t %d\t\t\n", pFirst->mName,
				pFirst->mSong, pFirst->mSinger
				, pFirst->mDate, pfirst->mFlow);
			return;
		}
		pFirst = pFirst->pNext;	//指向下一个节点
	}
	pFirs     t = NULL;
	printf("\n\n\n\n\t\t\t\t\t   没有找到要查询的专辑信息......\n\n");
}
