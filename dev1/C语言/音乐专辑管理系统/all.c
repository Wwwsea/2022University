#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
#include<string.h> 

void Init()
{													  //��ʼҳ�� 
	printf("��ӭʹ�ñ�ϵͳ\n");
	int i;
	printf("                        ");
	char hallo[]={"��������ϵͳ"};
	for(i=0;i<strlen(hallo);i++){
		printf("%c",hallo[i]);
		Sleep(10);
	}
	
}



typedef struct Music{
	char mName[56];
	char mSong[56];
	char mSinger;
	int mDate;
	int mFlow;
	struct Music *pNext;
	 
}MUS,*PMUS;
PMUS pHead=NULL; 		//����ͷָ�� 
PMUS pNew=NULL;         //�����ѧ����Ϣ 
int iCount=0;             //���� 

void SaveData()          //���ߣ�wanguy 
{
	PMUS pFirst = pHead->pNext;	//ָ���һ���ڵ� �������Ϊ NULL pCurrentΪ NULL

	FILE* fWrite = fopen("music.dat", "wb");
	if (fWrite == NULL)
	{
		system("cls");              //ִ��������ֻ�ܿ������ 
		printf("����ʧ��...\n");
		quit();
	}
	while (pFirst != NULL)		//��������ר����Ϣ	
	{
		fwrite(pFirst, sizeof(MUS), 1, fWrite);
		pFirst = pFirst->pNext;	//ָ����һ���ڵ�
	}
	pFirst = NULL;
	fclose(fWrite);
}
 
 
 
void Show()
{
	//չʾ����ר����Ϣ 
	Head();
	PMUS pFirst = pHead->pNext;	//ָ���һ���ڵ� �������Ϊ NULL pCurrentΪ NULL
	int i = 1;
	printf("\t\t\t**********************���������� %d ��ר��*********************\n\n\n", iCount);
	printf("\t\t\t���\tר������\t��������\t����\t��������\t������\t�ܷ�\n\n");
	while (pFirst != NULL)	//�����������ר�� 
	{
		printf("\t\t\t %d\t %s\t %s\t %s\t %d\t\t%d\n",i,pFirst->mName,pFirst->mSong
			, pFirst->mSinger, pFirst->mDate, pFirst->mFlow);
		pFirst = pFirst->pNext;	//ָ����һ���ڵ�
		i++;	//�±�Ӽ�
	}
	pFirst = NULL;
	printf("\n\n\n");
}


void Delete()  
{
	//ɾ�����ר����Ϣ 
	Head();

	char Name[56];
	char operate;
	
	Show();
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
				, pFirst->mDate, pFirst->mFlow);
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
	
	SaveDate();
	Show();
}


void Quit()
{
	//�˳���������½������˵�
	char ch;
	int i;
	printf("\n\t ");
	for (i = 0; i < 56; i++)
	{
		printf("* ");
		Sleep(10);
	}
	printf("\n\n\t\t\t\tҪ���ص�¼���水�����\t\t�˳������������밴Esc��\n");
	ch = getchar();
	if (ch == 27)	//esc������
	{
		SaveData();
		exit(0);
	}
	//���½������˵�
	Menu();
}



void Swap(PMUS mus1, PMUS mus2)
{
//����ר����Ϣ 
	strcpy(mus1->mName, mus2->mName);
	strcpy(mus1->mSong, mus2->mSong);

	mus1->mDate = mus2->mDate;
	mus1->mFlow = mus2->mFlow;

}


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

void Change()
{
	//�޸�ר����Ϣ 
	Head();
	char Name[56];
	char operate;
	PMUS pFirst = pHead->pNext;	//ָ���һ���ڵ� �������Ϊ NULL pFirstΪ NULL
	printf("\t\t\t\t\t\t�޸�ר����Ϣ��\n\n\n");
	printf("\t\t\t\t\t\t������ר�����ƣ�");
	scanf("%s", Name);
	//����ר����Ϣ
	
	while (pFirst != NULL)	//��������ר�� 
	{
		if (strcmp(pFirst->mName, Name) == 0)
		{
			printf("\n\n\n\t\t\t\t\tҪ�޸ĵ�ר����Ϣ...\n\n");
			printf("\n\n\t\t\t\t\tר������\t����\t����\t��������\t������\n\n");
			printf("\t\t\t\t\t %s\t %s\t %s\t %d\t %d\t\t\n", pFirst->mName,
				pFirst->mSong, pFirst->mSinger
				, pFirst->mDate, pFirst->mFlow);
			printf("\n\n\n\t\t\t\t\t�Ƿ��޸ĸ�ר����Ϣ(y/Enter):");
			operate = getchar();
			if (operate == 'y' || operate == 'Y' || operate == 13)	//13�ǻس���Enter��ASCIIֵ
			{
				//�޸�ȫ������
				printf("\n\n\t\t\t\t\t��������ר����Ϣ:\n\n\t\t\t\t\t\tר������:");
				scanf("%s", pFirst->mName);
				printf("\n\t\t\t\t\t\t����:");
				scanf("%s", pFirst->mSong);
				printf("\n\t\t\t\t\t\t����:");
				scanf("%s", pFirst->mSinger);
				printf("\n\t\t\t\t\t\t��������:");
				scanf("%d", &pFirst->mDate);
				printf("\n\t\t\t\t\t\t������:");
				scanf("%d", &pFirst->mFlow);
				
				printf("\n\n\n\t\t\t\t\t�޸ĳɹ�...\n\n");
				pFirst = NULL;
				return;
			}
			else {
				printf("\n\n\n\t\t\t\t\t�޸�ʧ��...\n\n");
				return;
			}
			return;
		}
		pFirst = pFirst->pNext;	//ָ����һ���ڵ�
	}
	pFirst = NULL;
	printf("\n\n\n\n\t\t\t\t\t   û���ҵ�Ҫ��ѯ��ר����Ϣ......\n\n");
	SaveDate(); 
	Read();
	
} 

void Search()
{
	Head();
	char Name[56];
	PMUS pFirst = pHead->pNext;	//ָ���һ���ڵ� �������Ϊ NULL pFirstΪ NULL
	printf("\t\t\t\t\t\t��ѯר����Ϣ��\n\n\n");
	printf("\t\t\t\t\t\t������ר�����ƣ�");
	scanf("%s", Name);
	//����ר����Ϣ

	while (pFirst != NULL)		//��������ר�� 
	{
		if (strcmp(pFirst->mName, Name) == 0)
		{
				printf("\n\n\n\t\t\t\t\tҪ��ѯ��ר����Ϣ...\n\n");
			printf("\n\n\t\t\t\t\tר������\t����\t����\t��������\t������\n\n");
			printf("\t\t\t\t\t %s\t %s\t %s\t %d\t %d\t\t\n", pFirst->mName,
				pFirst->mSong, pFirst->mSinger
				, pFirst->mDate, pFirst->mFlow);
			return;
		}
		pFirst = pFirst->pNext;	//ָ����һ���ڵ�
	}
	pFirst = NULL;
	printf("\n\n\n\n\t\t\t\t\t   û���ҵ�Ҫ��ѯ��ר����Ϣ......\n\n");
}


void Read()
{
	//��ȡר����Ϣ 
	FILE* fRead = fopen("music.dat", "rb");
	if (fRead == NULL)
	{
		SaveData();	//�ļ������ھʹ����ļ�
		return;
	}
	rewind(fRead);	//���ļ��ڲ�ָ���ƻ��ļ���ͷ
	while (1)
	{
		pNew = (PMUS)malloc(sizeof(MUS));	//����һ���ڴ�
		fread(pNew, sizeof(MUS), 1, fRead);	//1 ��ʾ��ȡһ��MUS�ֽڴ�С��Ԫ
		if (feof(fRead)) break;				//�ļ�ĩβ�˳�
		//ͷ�巨��������
		pNew->pNext = pHead->pNext;			
		pHead->pNext = pNew;
		pNew = NULL;
		iCount++;
	}
	Sort();
	fclose(fRead);
}

void Add()
{
	Head();
	//���ר����Ϣ
	pNew=(PMUS)malloc(sizeof(MUS));					  //���³�Ա�����ڴ� 
	printf("\3t���ר����Ϣ��\3n\3t���ƣ�");
	scanf("%s",pNew->mName);
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


void Menu()
{													  //��ҳ�� 
    int n;   //������
	
	do
	{
		printf("\t\t******������ר������ϵͳ��*************\n");
		printf("\n\t\t\t 1. ����ר����Ϣ                     ");
		printf("\n\t\t\t 2. ���ר����Ϣ                     ");
		printf("\n\t\t\t 3. �޸�ר����Ϣ                     ");
		printf("\n\t\t\t 4. ɾ��ר����Ϣ                     ");
		printf("\n\t\t\t 5. ���ר����Ϣ                     ");
		printf("\n\t\t\t 6. ����ר����Ϣ                     ");
		printf("\n\t\t\t 7. ���ȶ�����                       ");
		printf("\n\t\t\t 8. �˳�ϵͳ                         ");
		printf("\n\n\t\t***********************************\n");

		printf("������ѡ��(1-8): [ ]\b\b");
		scanf("%d", &n);

		
	}while(n < 1 || n > 8);

	//���ø�����ģ��
	switch(n)
	{
	case 1:  Input();   break;    //����ģ��
	case 2:  Add();     break;    //׷��ģ��
	case 3:  Change();  break;    //�޸�ģ��
	case 4:  Delete();  break;    //ɾ��ģ��
	case 5:  Read();    break;    //���ģ��
	case 6:  Search();  break;    //����ģ��
	case 7:  Sort();    break;    //����ģ��
	case 8:  Exit(0);                //�˳�
	}
}//Menu

/*********************������**********************/
int main(void)
{
   Menu();  //�����������

   return 0;
}//main
