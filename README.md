# KotlinPractice

Git Commands :
Day-1
======
# What is VCS. Why we need VCS.
	VCS features.

#
GIT Installation (Ubuntu):
$ sudo apt-get update
$ sudo apt-get install git

Verify Installation:
	which git
	git --version


GIT Uninstallation:
$ sudo apt-get remove git

#
Git Architecture Diagram
	- Centralized VCS -  Ex: CVS/SVN/Clearcase/Perforce
	- Distributed VCS -  Ex: GIT/Bitkeeper


Day-2
======
Creating remote repository in github
===============
1. create an account in github.com
	URL: https://github.com

2. login github.com with your credentials. 	
	click on "new repository" --> give a name "flipkart-ecomerce" --> "create reopository" 

3. copy the repo URL from Github:
	https://github.com/nageshvkn/flipkart-ecomerce.git

4. Clone the source code from remote repository using 'git clone' command
	git clone https://github.com/nageshvkn/flipkart-ecomerce.git

5. cd "flipkart-ecomerce" and observe ".git" folder. ".git" is called as "Local Reposiotory".

6. Create some sample code and submit the code to remote repo.
	--> touch Login.java
	--> git add Login.java
	--> git commit Login.java -m "login module code"
	--> git push

	--> git log Login.java

#
- Git Commit structure
	User/Email
	Timestamp
	Commit message
	
#
SHA / Version / Revison


#
Setting up mandatory configurations:
=============================================
$ git config --global user.name "Nageswara Rao P"
$ git config --global user.email "nageshvkn@gmail.com"

$ git config --global credential.helper cache

Check the configurations using below command
$ git config --list

Git stores all configurations in below file
"/home/gamut/.gitconfig"


Day-3
======
# Understand Git Jargon.
	- Remote Repository
	- Working Directory
	- Local Repository
	- Stage/"Staging Index"


# Skip staging
	git commit -am "submit all pending changes"
Note: If you want to skip the staging, you need to commit all pending changes.


# Creating up Local repository
1. create/initialize a local repository with 'git init' command
$ git init gamutkart


2. Observe the local repository
ls -a (you can see the .git folder. this is called the "local repository")

3.
create some source code.. ex: vim Login.java

4.
Adding the file to STAGE.
$ git add Login.java

5.
Commiting the file to local repository
$ git commit Login.java -m "lgoin module code"

6.
Check the log of Login.java using log command.
$ git log Login.java


Day-4
======
# History - Deep Dive
	$ git log Login.java
	$ git log

	Options:
		- git log -n2
		- git log --author="nageshvkn"
		- git log --since="2016/12/13"
		- git log --until="2016/12/13"
		- git log --grep="DB code"		
		- git log --oneline

#Qn.
Show me all logs committed by user "Ram" AND has a commit message "math function" in it.

$ git log --author="Ram" --grep="math function"


Day-5
=====
# GIT Commands

1.  
git diff Login.java

git diff --staged Login.java

git diff  089871935..fc894a6bf6d2e


2. Deleting a file

	A.) git rm OMS.java
	    git commit OMS.java -m "comment"


4. Renaming a file/folder
	A.) git mv Login.java Login1.java
		git commit -m "rename Login"
			
#
Git will carry the history of old file to new file. Use --follow option to see complete history. 
	$ git log --follow Login.java


Day-6
=======
# BRANCHING
	A. What is a branch?
	B. Why and When we create a branch?
	C. Branching Stratogy overview


# List all the branches
	$ git branch
	
# Creating a new branch
	$ git branch dev_1.2.3

# Push new branch to remote repository
	$ git push --set-upstream origin dev_1.2.3

		
# Switching from one branch to another
	$ git checkout dev_1.2.3
		
# Creating and switching to a newly created branch
	$ git checkout -b dev_1.2.4

# How do you clone a single branch from remote repository
	$ git clone -b dev_1.2.4 --single-branch https://github.com/nageshvkn/flipkart899.git

# List all remote branches
	$ git branch -r

#
HEAD

HEAD is a pointer in git which
	- Always points to the latest commit in the repository
	- Always points to tip of the current reposiotory
	- Always points to parent of the next commit


Day-7
======

# Undoing the changes:
undo/revert local changes from source area
	$ git checkout -- LoginWeb.java

Unstage the changes from STAGE area
	$ git reset HEAD LoginWeb.java


# Show all the files with content difference that are modified as part of a commit
git show <SHA>
git show b85a6e123

# List only files that are committed as part of a revision.
	$ git diff-tree --no-commit-id --name-only -r 41a7c2a456a


Day-8
======
Merging:
=========
# FAST-FORWARD MERGE

BEFORE MERGE:
-------------
			master
			 |
----C1--C2---C3
			 |
			 ----------C4----C5  
								dev_1.2.3
		
AFTER MERGE:
-------------
 			     			master
			     			  |
----C1----C2---C3------C4----C5
		             		  |
			     			dev_1.2.3


Excercise:
===========
# List all the branches
	$ git branch

# Create a new branch
	$ git branch dev_1.2.3

# Add some changes to newely created branch i.e dev_1.2.3
	$ Modify/Add some files	
	$ git add	
	$ git commit 

# Now merge the code from dev_1.2.3 to master branch
  Before merge, make sure that you are on target branch i.e master (source branch: dev_1.2.3)
	$ git checkout master

# You have master code in source since currently checkout branch is master. Now bring/merge the changes from dev_1.2.3 to master by running below command. 
Git merge command merges the changes from dev_1.2.3 to master.
Verify the chages.
	$ git merge dev_1.2.3

# Abservce the changes from dev_1.2.3 into master branch.

# git push



MERGING W/ CONFLICT:
=================

# List all the branches
	$ git branch

# Create a new branch
	$ git branch dev_1.2.3


# Take a file which is common in master and dev_1.2.3 branch.
  ex: Login.java

# Make sure Login.java has below content in master and dev_1.2.3 branch
	Login.java
		line#5 --> int a = 10;
	
# To create a conflict situation, we need to modify same line in two branches with different content.

	ex: Login.java (master)
			line#5 --> int a =100;
		
		Login.java (dev_1.2.3)
			line#5 --> int a = 200;


# Now merge the code from dev_1.2.3 to master branch
  Before merge, make sure that you are on target branch i.e master (source branch: dev_1.2.3)
	$ git checkout master

# You have master code now, since currently checkout branch is master. Now bring/merge the changes from dev_1.2.3 to master by running below command. 
Git merge command merges the changes from dev_1.2.3 to master.

	$ git merge dev_1.2.3

# Run git status command to list conflict file

#
  Resolve the conflict and commit the merge

# Run git push command to move the merge to Remote.


# What is Conflict:
If two users modify the same file in source and target branches and if the same line has different content, git can't decide which user's code it has to take. we call this situation as conflict.

# How do you resolve the conflict: 
- Open the conflict file--> remove conflict markers-->select the right content.
- git add
- git commit


#	
git remote
	PULL
	FETCH
	PUSH
	CLONE

Store credentials:
$ git config credential.helper store



NOTES:
SVN & Git differences:
==========================
1.
SVN is a centralised version control system. In svn, when a user checkout’s the repository, he will get only the source code. Repository is not distributed to the user. In SVN multiple users connect to a single/centralized server. If that server goes down, no user will be able to work.

	Where as Git is distributed VCS. In the sense, when user clones the repository, he will get source code as well as complete repository on his local disk. since repository is distributed across multiple users and each user has their own local repository, user will be able to submit the changes locally without connecting to the master server. (i.e he can also work offline)

2.
Git has staging area. Users can leverage this staging area to stage/save all the changes related to some issue/bug and  commit everything at once into local repository. hence, all the changes will be recorded as part of single sha/commit. user's get an opportunity to logically group the changes and commit as single changeset. this enables better tracking.

3.
Since git is distributed in nature, almost all transactions happen locally in the client machine and hence less overhead on the server so git is faster.
Users are free to create any no. branches in Git. where as in svn, all branches reside in server side, so may cause svn to be overloaded with multiple requests.

4.
Git seems to be good with merging.

5.
Git stores each change as SHA values but SVN uses simple numbers as revisions.




Qns:
===========
How do you pull a single branch / how do you make one branch as default.
How to compare two branches.


explain: local to remote
=========================
#
creating local repository
1. git init nexamatic1

#
create remote reposiotry
#
making local repository as remote
$ git remote add nexamatic1 https://github.com/nageshvkn/nexamatic1.git

#
git push nexamatic1

# If local and remore repositories are same
$ git push --set-upstream nexamatic1 master


# If local and remote repositories are different
git pull https://github.com/nageshvkn/nexamatic1.git

Note: when it opens a new window press: Ctrl+x

#
$ git push --set-upstream https://github.com/nageshvkn/nexamatic1.git master







