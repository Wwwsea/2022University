/******************************************************************************

#include<stdio.h>
#include<conio.h>
#include<Windows.h>


typedef enum Menu
{
	Exit,Lessons,Show,Add,Sort,Change,Delete,Search
}MENU;

typedef struct Student //��������ĸ��д�Ժͱ�������
{
	char cName[50];
	char cNumber[50];
	int iMath;
	int iEnglish;
	int iProgram;
	int iScore;
	struct Student  *pNext;
}STU,*PSTU;	

PSTU pHead = NULL;	//��Ϣѧ��ͷ���
PSTU pNew = NULL;	//�����ѧ����Ϣ
size_t iCount = 0;	//ѧ������
char UserName[10];
char UserWord[10];

void Init();
void MainMenu();
void StuManage();
void Head();
void Login();
int isLogin();

int MenuSelect();
void ReadData();
void SaveData();
void Quit();
void Lessons_Information();
void Show_Information();
void Add_Information();
void Sort_Information();
void Change_Information();
void Delete_Information();
void Search_Information();
void Swap(PSTU stu1,PSTU stu2);
int main()
{
	Init();
	MainMenu();
	return 0;
}

/*****************************************************************************
 �� �� ��  : MainMenu
 ��������  : ���˵�����
 �������  : ��
 �������  : ��
 �� �� ֵ  : void
 ���ú���  : 
 ��������  : 
 
 �޸���ʷ      :
  1.��    ��   : 2019��12��7��
    ��    ��   : DeRoy
    �޸�����   : �����ɺ���

*****************************************************************************/
void MainMenu()
{

		//��¼�ɹ�
		switch (MenuSelect())	//�˵�ѡ��
		{
		case Exit:		//�˳�����
			system("cls");
			Head();
			Quit();	//�˳��򷵻����˵�
			break;
		case Lessons:	//�γ���Ϣ
			system("cls");
			Lessons_Information();
			Quit();
			break;
		case Show:		//��ʾ����ѧ����Ϣ
			system("cls");
			Show_Information();
			Quit();
			break;
		case Add:		//���ѧ����Ϣ
			system("cls");
			Add_Information();
			Quit();
			break;
		case Sort:		//��ѧ����Ϣ�ֽܷ�������
			system("cls");
			Sort_Information();
			Show_Information();
			Quit();
			break;
		case Change:	//�޸�ѧ����Ϣ
			system("cls");
			Change_Information();
			Quit();
			break;
		case Delete:	//ɾ��ѧ����Ϣ
			system("cls");
			Delete_Information();
			Quit();
			break;
		case Search:	//��ѯѧ����Ϣ
			system("cls");
			Search_Information();
			Quit();
			break;
		}
	
}



//ѧ����Ϣ����ϵͳ�ַ�ͼ��
void Head()
{
	printf("\n");
	printf("\t\t\t\t\t�q �] % �r                   �q ```�r  \n");
	printf("\t\t\t\t\t(@^o^@) ѧ����Ϣ����ϵͳ (��:��)\n");
	printf("\t\t\t\t\t(~):(~)                  (~)v(~) \n");
	printf("\n\n\n");
}

//ѧ����Ϣ����ϵͳ ������ַ�ͼ��
void StuManage()
{
	printf("\n");
	printf("\t\t\t\t\t�q �] % �r                           �q ```�r  \n");
	printf("\t\t\t\t\t(@^o^@) ѧ����Ϣ����ϵͳ   �����(��:��)\n");
	printf("\t\t\t\t\t(~):(~)                          (~)v(~) \n");
	printf("\n\n\n");
}




int MenuSelect()
{
	char c;
	do
	{
		system("cls");
		Head();
		printf("\t\t\t\t   �q�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�����T�T�T�r\n");
		printf("\t\t\t\t   ��              ѧ����Ϣ����ϵͳ              ��\n");
		printf("\t\t\t\t   �t�T�T�T�����T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�T�s\n");
		printf("\t\t\t\t   ����������������������������������������������������������������������������������������-��\n");
		printf("\t\t\t\t   ��                                            ��\n");
		printf("\t\t\t\t   �� 1. �γ̰���                    2. ��ʾ���� ��\n");
		printf("\t\t\t\t   ��                                            ��\n");
		printf("\t\t\t\t   �� 3. �������                    4. �������� ��\n");
		printf("\t\t\t\t   ��                                            ��\n");
		printf("\t\t\t\t   �� 5. �޸�����                    6. ɾ������ ��\n");
		printf("\t\t\t\t   ��                                            ��\n");
		printf("\t\t\t\t   �� 7. ��ѯ����                    0. �˳����� ��\n");
		printf("\t\t\t\t   ��                                            ��\n");
		printf("\t\t\t\t   ��������������������������������������������������������������������������������������������\n");
		printf("\t\t\t\t\t\t  ����ѡ��(0-7):");
		c = getche();
	} while (c < '0' || c > '7');
	return c - '0';
}

/*****************************************************************************
�� �� ��  : ReadData
��������  : ��ȡ�ļ���Ϣ
�������  : ��
�������  : ��
�� �� ֵ  : void
���ú���  :
��������  :

�޸���ʷ      :
1.��    ��   : 2019��12��14��
��    ��   : DeRoy
�޸�����   : �����ɺ���

*****************************************************************************/
void ReadData()
{
	FILE* fRead = fopen("D:\\stuInformation.dat", "rb");
	if (fRead == NULL)
	{
		SaveData();	//�ļ������ھʹ����ļ�
		return;
	}
	rewind(fRead);	//���ļ��ڲ�ָ���ƻ��ļ���ͷ
	while (1)
	{
		pNew = (PSTU)malloc(sizeof(STU));	//����һ���ڴ�
		fread(pNew, sizeof(STU), 1, fRead);	//1 ��ʾ��ȡһ��MUS�ֽڴ�С��Ԫ
		if (feof(fRead)) break;				//�ļ�ĩβ�˳�
		//ͷ�巨��������
		pNew->pNext = pHead->pNext;			
		pHead->pNext = pNew;
		pNew = NULL;
		iCount++;
	}
	Sort_Information();
	fclose(fRead);
}

/*****************************************************************************
�� �� ��  : SaveData
��������  : д���ļ���Ϣ
�������  : ��
�������  : ��
�� �� ֵ  : void
���ú���  :
��������  :

�޸���ʷ      :
1.��    ��   : 2019��12��14��
��    ��   : DeRoy
�޸�����   : �����ɺ���

*****************************************************************************/
void SaveData()
{
	FILE* fWrite = fopen("D:\\stuInformation.dat", "wb");
	if (fWrite == NULL)
	{
		system("cls");
		printf("����ʧ��...\n");
		Quit();
	}
	PSTU pCurrent = pHead->pNext;	//ָ���һ���ڵ� �������Ϊ NULL pCurrentΪ NULL
	while (pCurrent != NULL)		//��������ѧ����Ϣ	
	{
		fwrite(pCurrent, sizeof(STU), 1, fWrite);
		pCurrent = pCurrent->pNext;	//ָ����һ���ڵ�
	}
	pCurrent = NULL;
	fclose(fWrite);
}

/*****************************************************************************
 �� �� ��  : Lessons_Information
 ��������  : �γ���Ϣ
 �������  : ��
 �������  : ��
 �� �� ֵ  : void
 ���ú���  : 
 ��������  : 
 
 �޸���ʷ      :
  1.��    ��   : 2019��12��7��
    ��    ��   : DeRoy
    �޸�����   : �����ɺ���

*****************************************************************************/
void Lessons_Information()
{
	Head();
	printf("\t\t\t�X�T�T�T�T�T�T�T�T�T�T�T�T�j�T�T�T�T�T�T�T�T�T�T�T�T�j�T�T�T�T�T�T�T�T�T�T�T�T�j�T�T�T�T�T�T�T�T�T�T�T�T�j�T�T�T�T�T�T�T�T�T�T�T�T�[\n");
	printf("\t\t\t�U  �ߵ���ѧ  �U  ��ѧӢ��  �U  �ߵ���ѧ  �U  ��ѧӢ��  �U  �ߵ���ѧ  �U\n");
	printf("\t\t\t�^�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a\n");
	printf("\t\t\t�U  ��ɢ��ѧ  �U  ��ѧ����  �U  ��ɢ��ѧ  �U  ��ѧ����  �U  ��ɢ��ѧ  �U\n");
	printf("\t\t\t�^�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a\n");
	printf("\t\t\t�U            �U            �U            �U            �U            �U\n");
	printf("\t\t\t�^�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a\n");
	printf("\t\t\t�U  �������  �U  ��ɢ��ѧ  �U  �������  �U            �U  �������  �U\n");
	printf("\t\t\t�^�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a\n");
	printf("\t\t\t�U            �U            �U            �U            �U            �U\n");
	printf("\t\t\t�^�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a�T�T�T�T�T�T�T�T�T�T�T�T�a\n");
}

/*****************************************************************************
 �� �� ��  : Quit
 ��������  : �˳���������½������˵�
 �������  : ��
 �������  : ��
 �� �� ֵ  : void
 ���ú���  : 
 ��������  : 
 
 �޸���ʷ      :
  1.��    ��   : 2019��12��7��
    ��    ��   : DeRoy
    �޸�����   : �����ɺ���

*****************************************************************************/
void Quit()
{
	char ch;
	int i; 
	printf("\n\t ");
	for (i = 0; i < 50; i++)
	{
		printf("* ");
		Sleep(10);
	}
	printf("\n\n\t\t\t\tҪ���ص�¼���水�����\t\t�˳������������밴Esc��\n");
	ch = getch();
	if (ch == 0x1b)	//esc������
	{
		SaveData();
		_exit(0);
	}
	//���½������˵�
	MainMenu();
}

/*****************************************************************************
 �� �� ��  : Show_Information
 ��������  : ��ʾ����ѧ����Ϣ
 �������  : ��
 �������  : ��
 �� �� ֵ  : void
 ���ú���  : 
 ��������  : 
 
 �޸���ʷ      :
  1.��    ��   : 2019��12��7��
    ��    ��   : DeRoy
    �޸�����   : �����ɺ���

*****************************************************************************/
void Show_Information()
{
	Head();
	PSTU pCurrent = pHead->pNext;	//ָ���һ���ڵ� �������Ϊ NULL pCurrentΪ NULL
	int index = 1;
	printf("\t\t\t**********************���������� %d ��ѧ��*********************\n\n\n", iCount);
	printf("\t\t\t���\tѧ��\t����\t����\tӢ��\t�������\t�ܷ�\n\n");
	while (pCurrent != NULL)	//�����������ѧ��
	{
		printf("\t\t\t %d\t %s\t %s\t %d\t %d\t %d\t\t%d\n", index, pCurrent->cNumber, pCurrent->cName, pCurrent->iMath
			, pCurrent->iEnglish, pCurrent->iProgram, pCurrent->iScore);
		pCurrent = pCurrent->pNext;	//ָ����һ���ڵ�
		index++;	//�±�Ӽ�
	}
	pCurrent = NULL;
	printf("\n\n\n");
}

/*****************************************************************************
 �� �� ��  : Add_Information
 ��������  : ���ѧ����Ϣ
 �������  : ��
 �������  : ��
 �� �� ֵ  : void
 ���ú���  : 
 ��������  : 
 
 �޸���ʷ      :
  1.��    ��   : 2019��12��7��
    ��    ��   : DeRoy
    �޸�����   : �����ɺ���

*****************************************************************************/
void Add_Information()
{
	
	
	Head();
	/************���ѧ����Ϣ***********/
	pNew = (PSTU)malloc(sizeof(STU));
	printf("\t\t\t\t\t\t���ѧ����Ϣ:\n\n\n\n\t\t\t\t\t\tѧ��:");
	scanf("%s", pNew->cNumber);
	printf("\n\t\t\t\t\t\t����:");
	scanf("%s", pNew->cName);
	printf("\n\t\t\t\t\t\t�ߵ���ѧ:");
	scanf("%d", &pNew->iMath);
	printf("\n\t\t\t\t\t\t��ѧӢ��:");
	scanf("%d", &pNew->iEnglish);
	printf("\n\t\t\t\t\t\t�������:");
	scanf("%d", &pNew->iProgram);
	pNew->iScore = pNew->iEnglish + pNew->iMath + pNew->iProgram;
	pNew->pNext = pHead->pNext;
	pHead->pNext = pNew;
	pNew = NULL;
	iCount++;
}

/*****************************************************************************
 �� �� ��  : Sort_Information
 ��������  : ��ѧ����Ϣ��������
 �������  : ��
 �������  : ��
 �� �� ֵ  : void
 ���ú���  : 
 ��������  : 
 
 �޸���ʷ      :
  1.��    ��   : 2019��12��7��
    ��    ��   : DeRoy
    �޸�����   : �����ɺ���

*****************************************************************************/
void Sort_Information()
{
	if (iCount < 2)		//һ��ѧ������Ҫ����
	{
		return;	
	}
	//�Ӵ�С���� ð������
	PSTU pCurrent,pTemp;
	STU Temp;
	for (pCurrent = pHead->pNext; pCurrent != NULL; pCurrent = pCurrent->pNext)
	{
		for (pTemp = pCurrent->pNext; pTemp != NULL; pTemp = pTemp->pNext)
		{
			if (pCurrent->iScore < pTemp->iScore)
			{
				Swap(&Temp, pCurrent);
				Swap(pCurrent, pTemp);
				Swap(pTemp, &Temp);
			}
		}
	}
}

/*****************************************************************************
 �� �� ��  : Change_Information
 ��������  : �޸�ѧ����Ϣ
 �������  : ��
 �������  : ��
 �� �� ֵ  : void
 ���ú���  : 
 ��������  : 
 
 �޸���ʷ      :
  1.��    ��   : 2019��12��7��
    ��    ��   : DeRoy
    �޸�����   : �����ɺ���

*****************************************************************************/
void Change_Information()
{
	Head();
	char ID[10];
	char operate;
	printf("\t\t\t\t\t\t�޸�ѧ����Ϣ��\n\n\n");
	printf("\t\t\t\t\t\t������ѧ��ѧ�ţ�");
	scanf("%s", ID);
	//����ѧ����Ϣ
	PSTU pCurrent = pHead->pNext;	//ָ���һ���ڵ� �������Ϊ NULL pCurrentΪ NULL
	while (pCurrent != NULL)	//��������ѧ��
	{
		if (strcmp(pCurrent->cNumber, ID) == 0)
		{
			printf("\n\n\n\t\t\t\t\tҪ�޸ĵ�ѧ����Ϣ...\n\n");
			printf("\n\n\t\t\t\t\tѧ��\t����\t����\tӢ��\t�������\t�ܷ�\n\n");
			printf("\t\t\t\t\t %s\t %s\t %d\t %d\t %d\t\t%d\n", pCurrent->cNumber,
				pCurrent->cName, pCurrent->iMath
				, pCurrent->iEnglish, pCurrent->iProgram,pCurrent->iScore);
			printf("\n\n\n\t\t\t\t\t�Ƿ��޸ĸ�ѧ����Ϣ(y/Enter):");
			operate = getch();
			if (operate == 'y' || operate == 'Y' || operate == 13)	//13�ǻس���Enter��ASCIIֵ
			{
				//�����ֿ�����һ���˵������޸�ĳһ��������Ϊ�˷��㣬ֱ���޸�ȫ������
				printf("\n\n\t\t\t\t\t��������ѧ����Ϣ:\n\n\t\t\t\t\t\tѧ��:");
				scanf("%s", pCurrent->cNumber);
				printf("\n\t\t\t\t\t\t����:");
				scanf("%s", pCurrent->cName);
				printf("\n\t\t\t\t\t\t�ߵ���ѧ:");
				scanf("%d", &pCurrent->iMath);
				printf("\n\t\t\t\t\t\t��ѧӢ��:");
				scanf("%d", &pCurrent->iEnglish);
				printf("\n\t\t\t\t\t\t�������:");
				scanf("%d", &pCurrent->iProgram);
				pCurrent->iScore = pCurrent->iEnglish + pCurrent->iMath + pCurrent->iProgram;
				printf("\n\n\n\t\t\t\t\t�޸ĳɹ�...\n\n");
				pCurrent = NULL;
				return;
			}
			else {
				printf("\n\n\n\t\t\t\t\t�޸�ʧ��...\n\n");
				return;
			}
			return;
		}
		pCurrent = pCurrent->pNext;	//ָ����һ���ڵ�
	}
	pCurrent = NULL;
	printf("\n\n\n\n\t\t\t\t\t   û���ҵ�Ҫ��ѯ��ѧ����Ϣ......\n\n");
}

/*****************************************************************************
 �� �� ��  : Delete_Information
 ��������  : ɾ��ѧ����Ϣ
 �������  : ��
 �������  : ��
 �� �� ֵ  : void
 ���ú���  : 
 ��������  : 
 
 �޸���ʷ      :
  1.��    ��   : 2019��12��7��
    ��    ��   : DeRoy
    �޸�����   : �����ɺ���

*****************************************************************************/
void Delete_Information()
{
	Head();
	char ID[10];
	char operate;
	printf("\t\t\t\t\t\tɾ��ѧ����Ϣ��\n\n\n");
	printf("\t\t\t\t\t\t������ѧ��ѧ�ţ�");
	scanf("%s", ID);
	//����ѧ����Ϣ
	PSTU pCurrent = pHead;	//ָ��ͷ��� 
	
	while (pCurrent->pNext != NULL)	//�����������ѧ��
	{
		if (strcmp(pCurrent->pNext->cNumber, ID) == 0)
		{
			//��Ϣ��������Ҫɾ����ѧ����Ϣ
			printf("\n\n\n\t\t\t\t\tҪɾ����ѧ����Ϣ...\n\n");
			printf("\n\n\t\t\t\t\tѧ��\t����\t����\tӢ��\t�������\t�ܷ�\n\n");
			printf("\t\t\t\t\t %s\t %s\t %d\t %d\t %d\t\t%d\n",pCurrent->pNext->cNumber, 
				pCurrent->pNext->cName, pCurrent->pNext->iMath, pCurrent->pNext->iEnglish
				, pCurrent->pNext->iProgram,pCurrent->pNext->iScore);
			printf("\n\n\n\t\t\t\t\t�Ƿ�ɾ����ѧ����Ϣ(y/Enter):");
			operate = getch();
			if (operate == 'y' || operate == 'Y' || operate == 13)	//13�ǻس���Enter��ASCIIֵ
			{
				//ɾ��ѧ����Ϣ
				PSTU pTemp = pCurrent->pNext;	//����PSTUָ�� pTemp ָ��Ҫɾ���Ľڵ�
				pCurrent->pNext = pTemp->pNext;	
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
		pCurrent = pCurrent->pNext;	//ָ����һ���ڵ�
	}
	printf("\n\n\n\n\t\t\t\t\t   û���ҵ�Ҫɾ����ѧ����Ϣ......\n\n");
}

/*****************************************************************************
 �� �� ��  : Search_Information
 ��������  : ��ѯѧ����Ϣ
 �������  : ��
 �������  : ��
 �� �� ֵ  : void
 ���ú���  : 
 ��������  : 
 
 �޸���ʷ      :
  1.��    ��   : 2019��12��7��
    ��    ��   : DeRoy
    �޸�����   : �����ɺ���

*****************************************************************************/
void Search_Information()
{
	Head();
	char ID[10];
	printf("\t\t\t\t\t\t��ѯѧ����Ϣ��\n\n\n");
	printf("\t\t\t\t\t\t������ѧ��ѧ�ţ�");
	scanf("%s", ID);
	//����ѧ����Ϣ
	PSTU pCurrent = pHead->pNext;	//ָ���һ���ڵ� �������Ϊ NULL pCurrentΪ NULL
	while (pCurrent != NULL)		//��������ѧ��
	{
		if (strcmp(pCurrent->cNumber, ID) == 0)
		{
			printf("\n\n\n\t\t\t\t\tҪ��ѯ��ѧ����Ϣ...\n\n");
			printf("\n\n\t\t\t\t\tѧ��\t����\t����\tӢ��\t�������\t�ܷ�\n\n");
			printf("\t\t\t\t\t %s\t %s\t %d\t %d\t %d\t\t%d\n", pCurrent->cNumber,
				pCurrent->cName, pCurrent->iMath
				, pCurrent->iEnglish, pCurrent->iProgram,pCurrent->iScore);
			return;
		}
		pCurrent = pCurrent->pNext;	//ָ����һ���ڵ�
	}
	pCurrent = NULL;
	printf("\n\n\n\n\t\t\t\t\t   û���ҵ�Ҫ��ѯ��ѧ����Ϣ......\n\n");
}

/*****************************************************************************
 �� �� ��  : Swap
 ��������  : ��������ѧ����Ϣ
 �������  : PSTU stu1  
             PSTU stu2  
 �������  : ��
 �� �� ֵ  : void
 ���ú���  : 
 ��������  : 
 
 �޸���ʷ      :
  1.��    ��   : 2019��12��7��
    ��    ��   : DeRoy
    �޸�����   : �����ɺ���

*****************************************************************************/
void Swap(PSTU stu1, PSTU stu2)
{
	strcpy(stu1->cName, stu2->cName);
	strcpy(stu1->cNumber, stu2->cNumber);
	stu1->iEnglish = stu2->iEnglish;
	stu1->iMath = stu2->iMath;
	stu1->iProgram = stu2->iProgram;
	stu1->iScore = stu2->iScore;
}
