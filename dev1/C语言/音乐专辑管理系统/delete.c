void Delete()   //作者：wanguy 
{
	//删除这个专辑信息 
	Head();
	char Name[56];
	char operate;
	
	PMUS pFirst = pHead;	//指向头结点
	PMUS pTemp = pFirst->pNext;	//定义PMUS指针 pTemp 指向要删除的节点
	printf("\t\t\t\t\t\t删除专辑信息：\n\n\n");
	printf("\t\t\t\t\t\t请输入专辑名称：");
	scanf("%s", Name);
	//遍历专辑信息
 
	
	while (pFirst->pNext != NULL)	//遍历输出所有专辑 
	{
		if (strcmp(pFirst->pNext->mName, Name) == 0)
		{
			//信息库里面有要删除的专辑信息
			printf("\n\n\n\t\t\t\t\t要删除的专辑信息...\n\n");
			printf("\n\n\t\t\t\t\t专辑名称\t歌曲\t歌手\t发售日期\t销售量\n\n");
			printf("\t\t\t\t\t %s\t %s\t %s\t %d\t %d\t\t\n", pFirst->mName,
				pFirst->mSong, pFirst->mSinger
				, pFirst->mDate, pfirst->mFlow);
			printf("\n\n\n\t\t\t\t\t是否删除该专辑信息(y/Enter):");
			operate = getch();
			if (operate == 'y' || operate == 'Y' || operate == 13)	//13是回车键Enter的ASCII值
			{
				//删除专辑信息

				pFirst->pNext = pTemp->pNext;	
				free(pTemp);
				iCount--;
				printf("\n\n\n\t\t\t\t\t删除成功...\n\n");
				return;
			}
			else{
				printf("\n\n\n\t\t\t\t\t删除失败...\n\n");
				return;
			}
		}
		pFirst = pFirst->pNext;	//指向下一个节点
	}
	printf("\n\n\n\n\t\t\t\t\t   没有找到要删除的专辑信息......\n\n");
}
