import React from 'react'
import Image from 'next/image'
import { BeakerIcon, HomeIcon } from '@heroicons/react/outline'
import { ChevronDownIcon, SearchIcon, StarIcon } from '@heroicons/react/solid'

function Header() {
  return (
    <div className='flex bg-white px-4 py-2 shadow-sm'>
        <div className='relative h-10 w-20 flex-shrink-0 cursor-pointer'>
            <Image 
                objectFit="contain"
                src="https://links.papareact.com/fqy" 
                layout="fill" />
        </div>

        <div className='flex items-center mx-7'>
            <HomeIcon className='h-5 w-5'/>
            <p className='ml-2 hidden flex-1 lg:inline'>Home</p>
            <ChevronDownIcon className='h-5 w-5' />
        </div>

        <form className='flex flex-1 items-center space-x-2 rounded-sm border border-gray-200 bg-gray-100 px-3 py-1'>
            <SearchIcon  className='h-6 w-6 text-gray-400'/>
            <input 
                className="flex-1 bg-transparenr" 
                type="text" 
                placeholder='Search Reddit'
            />
            <button type="submit" hidden></button>
        </form>
    </div>
  )
}

export default Header