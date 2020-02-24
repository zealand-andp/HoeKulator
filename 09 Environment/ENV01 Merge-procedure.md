# Merge-procedure
Merging skal foretages af en uafhængig reviewer, dvs. en der ikke har bidraget til branchens ændringer.

1. Kontroller at seneste commit for ***hver*** ændret fil følger retningslinjerne for review og commit descriptions jf. [ENV03 Commit-procedure](https://github.com/zealand-andp/HoeKulator/blob/master/09%20Environment/ENV03%20Commit-procedure.md)
   1. Branchens bidragsydere har ansvaret for få udført evt. manglende reviews
   2. Hvis der manglede reviews, start fra trin 1 igen
2. Pull master into branch
   1. Evt. merge-konflikter skal rettes af branchens bidragsydere
   2. Hvis der var merge-konflikter, start fra trin 1 igen
3. Pull branch into the master
   1. Anfør branchens bidragsydere som authors i merge description
   2. Anfør eget navn som merger i merge description
4. Afslut pull request såfremt det kan gøres uden merge-konflikter
   1. Hvis der er merge-konflikter så slettes pull request og trin 2 udføres igen

# Kendte krydsreferencer
* [ENV02 Branching-strategi og -procedure](https://github.com/zealand-andp/HoeKulator/blob/master/09%20Environment/ENV02%20Branching-strategi%20og%20-procedure.md)
