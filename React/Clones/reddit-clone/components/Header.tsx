import React from 'react'
import Image from 'next/image'
import { BeakerIcon, BellIcon, ChatIcon, GlobeIcon, HomeIcon, MenuIcon, PlusIcon, SparklesIcon, SpeakerphoneIcon, VideoCameraIcon } from '@heroicons/react/outline'
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

        <div className='mx-5 flex text-gray-500 items-center space-x-2 hidden lg:inline-flex'>
            <SparklesIcon className='icon'/>
            <GlobeIcon className='icon'/>
            <VideoCameraIcon className='icon'/>
            <hr className='h-10 border border-gray-100'/>
            <ChatIcon className='icon'/>
            <BellIcon className='icon'/>
            <PlusIcon className='icon'/>
            <SpeakerphoneIcon className='icon'/>
        </div>
        <div className='ml-5 flex items-center lg:hidden'>
            <MenuIcon className='icon'/> 
        </div>
        <div className='hidden lg:flex items-center p-2 cursor-pointer space-x-2 border-gray-100 '>
            <div className='relative h-5 w-5 flex-shrink-0'>
                <Image 
                    objectFit='contain'
                    src="https://links.papareact.com/231"
                    layout='fill'
                />   
            </div>
            <p className='text-gray-400'>Sign In</p>
        </div>
    </div>
  )
}

export default Header