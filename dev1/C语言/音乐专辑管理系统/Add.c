void Add()
{
	Head();
	//���ר����Ϣ
	pNew=(PMUS)malloc(sizeof(MUS));					  //���³�Ա�����ڴ� 
	printf("\3t���ר����Ϣ��\3n\3t��ţ�");
	scanf("%s",pNew->mNumber);
	printf("\n\3t��ר���ĸ���:");
	scanf("%s",pNew->mSong);
	printf("\n\3t��ר���������ĸ���:"); 
	scanf("%s",pNew->mSinger); 
	printf("\n\3t��ר���ķ�������:");
	scanf("%d",&pNew->mDate);
	
	printf("\n\3t��ר������������");
	scanf("%d",&pNew->mFlow);
	//����ͷ�巨 �ܲ��ƻ��������ʽ�ṹ 
	pNew->pNext=pHead->pNext;					//��β����������½ڵ��pNextָ��ͷ����pNext 
	pHead->pNext=pNew;							//ͷ�ڵ����һ���ڵ�ָ��Ҫ����Ľڵ� 
	pNew=NULL;
	iCount++;
	SaveDate();
	 
}
