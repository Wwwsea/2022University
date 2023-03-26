void Show()
{
	//展示所有专辑信息 
	Head();
	PMUS pFirst = pHead->pNext;	//指向第一个节点 如果链表为 NULL pCurrent为 NULL
	int i = 1;
	printf("\t\t\t**********************本名单共有 %d 张专辑*********************\n\n\n", iCount);
	printf("\t\t\t序号\t专辑名称\t所含歌曲\t歌手\t发售日期\t销售量\t总分\n\n");
	while (pFirst != NULL)	//遍历输出所有专辑 
	{
		printf("\t\t\t %d\t %s\t %s\t %s\t %d\t\t%d\n",i,pFirst->mName,pFirst->mSong
			, pFirst->mSinger, pFirst->mDate, pFirst->mFlow);
		pFirst = pFirst->pNext;	//指向下一个节点
		i++;	//下标加加
	}
	pFirst = NULL;
	printf("\n\n\n");
}

