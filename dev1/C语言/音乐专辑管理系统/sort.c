void Sort()
{
	PMUS pFirst,pTemp;
	MUS Temp;
	if (iCount < 2)		//һ��ר������Ҫ����
	{
		return;	
	}
	//�Ӵ�С���� ð������

	for (pFirst = pHead->pNext; pFirst != NULL; pFirst = pFirst->pNext)
	{
		for (pTemp = pFirst->pNext; pTemp != NULL; pTemp = pTemp->pNext)
		{
			if (pFirst->mFlow < pTemp->mFlow)
			{
				Swap(&Temp, pFirst);
				Swap(pFirst, pTemp);
				Swap(pTemp, &Temp);
			}
		}
	}
}
