void Add()
{
	Head();
	//添加专辑信息
	pNew=(PMUS)malloc(sizeof(MUS));					  //给新成员分配内存 
	printf("\3t添加专辑信息：\3n\3t编号：");
	scanf("%s",pNew->mNumber);
	printf("\n\3t该专辑的歌手:");
	scanf("%s",pNew->mSong);
	printf("\n\3t该专辑所包含的歌曲:"); 
	scanf("%s",pNew->mSinger); 
	printf("\n\3t该专辑的发售日期:");
	scanf("%d",&pNew->mDate);
	
	printf("\n\3t该专辑的销售量：");
	scanf("%d",&pNew->mFlow);
	//采用头插法 能不破坏链表的链式结构 
	pNew->pNext=pHead->pNext;					//首尾相连插入的新节点的pNext指向头结点的pNext 
	pHead->pNext=pNew;							//头节点的下一个节点指向要插入的节点 
	pNew=NULL;
	iCount++;
	SaveDate();
	 
}
