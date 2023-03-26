#include<stdio.h>
#include<malloc.h>
#include<stdlib.h>
#include<string.h> 

void Init()
{													  //初始页面 
	printf("欢迎使用本系统\n");
	int i;
	printf("                        ");
	char hallo[]={"即将进入系统"};
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
PMUS pHead=NULL; 		//建立头指针 
PMUS pNew=NULL;         //待添加学生信息 
int iCount=0;             //序数 

void SaveData()          //作者：wanguy 
{
	PMUS pFirst = pHead->pNext;	//指向第一个节点 如果链表为 NULL pCurrent为 NULL

	FILE* fWrite = fopen("music.dat", "wb");
	if (fWrite == NULL)
	{
		system("cls");              //执行清屏，只能看见输出 
		printf("保存失败...\n");
		quit();
	}
	while (pFirst != NULL)		//遍历所有专辑信息	
	{
		fwrite(pFirst, sizeof(MUS), 1, fWrite);
		pFirst = pFirst->pNext;	//指向下一个节点
	}
	pFirst = NULL;
	fclose(fWrite);
}
 
 
 
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


void Delete()  
{
	//删除这个专辑信息 
	Head();

	char Name[56];
	char operate;
	
	Show();
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
				, pFirst->mDate, pFirst->mFlow);
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
	
	SaveDate();
	Show();
}


void Quit()
{
	//退出程序或重新进入主菜单
	char ch;
	int i;
	printf("\n\t ");
	for (i = 0; i < 56; i++)
	{
		printf("* ");
		Sleep(10);
	}
	printf("\n\n\t\t\t\t要返回登录界面按任意键\t\t退出并保存数据请按Esc键\n");
	ch = getchar();
	if (ch == 27)	//esc键按下
	{
		SaveData();
		exit(0);
	}
	//重新进入主菜单
	Menu();
}



void Swap(PMUS mus1, PMUS mus2)
{
//交换专辑信息 
	strcpy(mus1->mName, mus2->mName);
	strcpy(mus1->mSong, mus2->mSong);

	mus1->mDate = mus2->mDate;
	mus1->mFlow = mus2->mFlow;

}


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
				, pFirst->mDate, pFirst->mFlow);
			printf("\n\n\n\t\t\t\t\t是否修改该专辑信息(y/Enter):");
			operate = getchar();
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
	Read();
	
} 

void Search()
{
	Head();
	char Name[56];
	PMUS pFirst = pHead->pNext;	//指向第一个节点 如果链表为 NULL pFirst为 NULL
	printf("\t\t\t\t\t\t查询专辑信息：\n\n\n");
	printf("\t\t\t\t\t\t请输入专辑名称：");
	scanf("%s", Name);
	//遍历专辑信息

	while (pFirst != NULL)		//遍历所有专辑 
	{
		if (strcmp(pFirst->mName, Name) == 0)
		{
				printf("\n\n\n\t\t\t\t\t要查询的专辑信息...\n\n");
			printf("\n\n\t\t\t\t\t专辑名称\t歌曲\t歌手\t发售日期\t销售量\n\n");
			printf("\t\t\t\t\t %s\t %s\t %s\t %d\t %d\t\t\n", pFirst->mName,
				pFirst->mSong, pFirst->mSinger
				, pFirst->mDate, pFirst->mFlow);
			return;
		}
		pFirst = pFirst->pNext;	//指向下一个节点
	}
	pFirst = NULL;
	printf("\n\n\n\n\t\t\t\t\t   没有找到要查询的专辑信息......\n\n");
}


void Read()
{
	//读取专辑信息 
	FILE* fRead = fopen("music.dat", "rb");
	if (fRead == NULL)
	{
		SaveData();	//文件不存在就创建文件
		return;
	}
	rewind(fRead);	//将文件内部指针移回文件开头
	while (1)
	{
		pNew = (PMUS)malloc(sizeof(MUS));	//申请一块内存
		fread(pNew, sizeof(MUS), 1, fRead);	//1 表示读取一个MUS字节大小单元
		if (feof(fRead)) break;				//文件末尾退出
		//头插法插入数据
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
	//添加专辑信息
	pNew=(PMUS)malloc(sizeof(MUS));					  //给新成员分配内存 
	printf("\3t添加专辑信息：\3n\3t名称：");
	scanf("%s",pNew->mName);
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


void Menu()
{													  //主页面 
    int n;   //存人数
	
	do
	{
		printf("\t\t******【音乐专辑管理系统】*************\n");
		printf("\n\t\t\t 1. 输入专辑信息                     ");
		printf("\n\t\t\t 2. 添加专辑信息                     ");
		printf("\n\t\t\t 3. 修改专辑信息                     ");
		printf("\n\t\t\t 4. 删除专辑信息                     ");
		printf("\n\t\t\t 5. 浏览专辑信息                     ");
		printf("\n\t\t\t 6. 查找专辑信息                     ");
		printf("\n\t\t\t 7. 按热度排序                       ");
		printf("\n\t\t\t 8. 退出系统                         ");
		printf("\n\n\t\t***********************************\n");

		printf("请输入选项(1-8): [ ]\b\b");
		scanf("%d", &n);

		
	}while(n < 1 || n > 8);

	//调用各功能模块
	switch(n)
	{
	case 1:  Input();   break;    //输入模块
	case 2:  Add();     break;    //追加模块
	case 3:  Change();  break;    //修改模块
	case 4:  Delete();  break;    //删除模块
	case 5:  Read();    break;    //浏览模块
	case 6:  Search();  break;    //查找模块
	case 7:  Sort();    break;    //排序模块
	case 8:  Exit(0);                //退出
	}
}//Menu

/*********************主函数**********************/
int main(void)
{
   Menu();  //函数调用语句

   return 0;
}//main
