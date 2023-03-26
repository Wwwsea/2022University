void Swap(PMUS mus1, PMUS mus2)
{
//交换专辑信息 
	strcpy(mus1->mName, mus2->mName);
	strcpy(mus1->mSong, mus2->mSong);
	strcpy(mus1->mSinger, mus2->mSinger);
	mus1->mDate = mus2->mDate;
	mus1->mFlow = mus2->mFlow;

}
