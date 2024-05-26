## Testing
![coverage.png](images%2Fcoverage.png)
> Reach 85% Code coverage with testing

## Profiling
![profiling.png](images%2Fprofiling.png)
> Seperti yang dapat dilihat, secara umum kecepatan aplikasi cukup konsisten, paling lambat di fungsi addOrder dan findAllOrders.
> Namun, karena findAllOrders diinherit dari JpaRepository, tidak ada yang dapat dilakukan untuk optimasi.
> Saya memilih untuk mengoptimasikan fungsi addOrder saja karena ini.

![optimized.png](images%2Foptimized.png)

>Dapat dilihat bahwa setelah optimasi waktu yang dibutuhan untuk addOrder hanya 88 dibandingkan yang tadinya 154.
> 
## Static Analysis
![pmdbefore.png](images%2Fpmdbefore.png)
> Setelah membenarkan beberapa warning dari pmd
![pmdafter.png](images%2Fpmdafter.png)
