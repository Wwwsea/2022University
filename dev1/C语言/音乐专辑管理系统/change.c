void Change()
{
	//修改专辑信息 
	Head();
	char Name[56];
	char operate;
	PMUS pFirst = pHead->pNext;	//指向第一个节点 如果链表为 NULL pFirst为 NULL
	printf("\t\t\t\t\t\t修改专辑信息：\n\n\n");
	printf("\t\t\t\t\t\t请输入专辑名称：");
	scanf("%s", Name);
	//遍历专辑信息
	
	while (pFirst != NULL)	//遍历所有专辑 
	{
		if (strcmp(pFirst->mName, Name) == 0)
		{
			printf("\n\n\n\t\t\t\t\t要修改的专辑信息...\n\n");
			printf("\n\n\t\t\t\t\t专辑名称\t歌曲\t歌手\t发售日期\t销售量\n\n");
			printf("\t\t\t\t\t %s\t %s\t %s\t %d\t %d\t\t\n", pFirst->mName,
				pFirst->mSong, pFirst->mSinger
				, pFirst->mDate, pfirst->mFlow);
			printf("\n\n\n\t\t\t\t\t是否修改该专辑信息(y/Enter):");
			operate = getch();
			if (operate == 'y' || operate == 'Y' || operate == 13)	//13是回车键Enter的ASCII值
			{
				//修改全部变量
				printf("\n\n\t\t\t\t\t重新输入专辑信息:\n\n\t\t\t\t\t\t专辑名称:");
				scanf("%s", pFirst->mName);
				printf("\n\t\t\t\t\t\t歌曲:");
				scanf("%s", pFirst->mSong);
				printf("\n\t\t\t\t\t\t歌手:");
				scanf("%s", pFirst->mSinger);
				printf("\n\t\t\t\t\t\t发售日期:");
				scanf("%d", &pFirst->mDate);
				printf("\n\t\t\t\t\t\t销售量:");
				scanf("%d", &pFirst->mFlow);
				
				printf("\n\n\n\t\t\t\t\t修改成功...\n\n");
				pFirst = NULL;
				return;
			}
			else {
				printf("\n\n\n\t\t\t\t\t修改失败...\n\n");
				return;
			}
			return;
		}
		pFirst = pFirst->pNext;	//指向下一个节点
	}
	pFirst = NULL;
	printf("\n\n\n\n\t\t\t\t\t   没有找到要查询的专辑信息......\n\n");
	SaveDate(); 
}
