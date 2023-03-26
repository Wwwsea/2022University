void Sort()
{
	PMUS pFirst,pTemp;
	MUS Temp;
	if (iCount < 2)		//一张专辑不需要排序
	{
		return;	
	}
	//从大到小排序 冒泡排序

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
